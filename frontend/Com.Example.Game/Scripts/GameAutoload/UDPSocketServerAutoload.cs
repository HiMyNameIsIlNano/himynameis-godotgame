using System;
using System.Diagnostics;
using Com.Example.Common.Attributes;
using Com.Example.Common.Network;
using Com.Example.Common.Services.Messageq;
using Com.Example.Common.Services.Protobuf.Grpc;
using Com.Example.Demo.Protobuf.Socket;
using Com.Example.Game.Scripts.GameStartup;
using Godot;

namespace Com.Example.Game.Scripts.GameAutoload
{
    public class UDPSocketServerAutoload : Node
    {
        private const int Port = 4444;

        private WebSocketServer Server { get; set; }

        [InjectedProperty] private IProtobufSerializerService ProtobufSerializerService { get; set; }

        [InjectedProperty] private IMessageQueueConnectionService MessageQueueConnectionService { get; set; }

        [InjectedProperty] private IGrpcChannelService GrpcChannelService { get; set; }

        public override void _Ready()
        {
            Console.WriteLine("Starting SoSe");
            InjectedPropertyResolver.Resolve(this);

            RegisterProtobufParsers();
            SocketServerRegisterEvents();
            SocketServerStart();

            // TODO: should this be awaited for?
            SignalBackendSocketServerConnectionPossible();
        }

        private void RegisterProtobufParsers()
        {
            ProtobufSerializerService.RegisterSerializer(typeof(SocketPushMessage), SocketPushMessage.Parser);
        }

        private void SocketServerRegisterEvents()
        {
            Server = new WebSocketServer();
            Server.Connect("client_connected", this, nameof(OnConnected));
            Server.Connect("client_disconnected", this, nameof(OnDisconnected));
            Server.Connect("client_close_request", this, nameof(OnCloseRequest));
            Server.Connect("data_received", this, nameof(OnDataReceived));
        }

        private void SocketServerStart()
        {
            Error error = Server.Listen(Port);
            if (error != Error.Ok)
            {
                Console.WriteLine("Unable to start the server");
                SetProcess(false);
            }

            Console.WriteLine($"Socket Server listening on port {Port}");
        }

        private void SignalBackendSocketServerConnectionPossible()
        {
            /*Task connectToServerTask = MessageQueueConnectionService.ConnectPlayerToMessageQueue();
            // TODO: What happens if the back end is not up at the time this request is fired. 
            await connectToServerTask.ContinueWith(ancestor =>
                Console.WriteLine("Finish signaling the Back End that a connection to Socket Server is possible..."));*/
        }

        private void OnConnected(int id, string protocol)
        {
            GD.Print($"Client {id} connected with protocol {protocol}");
            Server.GetPeer(id).SetWriteMode(WebSocketPeer.WriteMode.Binary);
        }

        private void OnDisconnected(int id, bool wasClean)
        {
            GD.Print($"Client {id} disconnected, clean {wasClean}");
            Server.GetPeer(id).Free();
        }

        private void OnCloseRequest(int id, int code, string reason)
        {
            GD.Print($"Client {id} disconnecting with code: {code}, reason: {reason}");
            Server.GetPeer(id).Close();
        }

        private void OnDataReceived(int id)
        {
            var data = Server.GetPeer(id).GetPacket();
            SocketPushMessage socketPushMessage =
                (SocketPushMessage) ProtobufSerializerService.Deserialize(data, typeof(SocketPushMessage));

            GD.Print(
                $"Got data from client {id}: Player: {socketPushMessage.PlayerId} and text: {socketPushMessage.Text}");
            Server.GetPeer(id).PutPacket(data);
        }


        public override void _ExitTree()
        {
            Debug.Assert(Server != null, "The Server IS null");
            Server.Stop();
            GrpcChannelService.CloseAsync();
        }

        public override void _Process(float delta)
        {
            Debug.Assert(Server != null, "The Server IS null");
            Server.Poll();
        }
    }
}