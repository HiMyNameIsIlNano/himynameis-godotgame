using System;
using Com.Example.Common.Network.Protobuf.Serializer;
using Com.Example.Demo.Protobuf.Socket;
using Godot;

namespace Com.Example.Game.Scripts.Socket
{
    public class UDPSocketServerAutoload : Node
    {
        private const int Port = 4444;

        private WebSocketServer Server { get; set; }

        //[InjectedProperty] private ProtobufSerializerService ProtobufSerializerService { get; set; }

        private ProtobufSerializerService ProtobufSerializerService { get; set; }

        public override void _Ready()
        {
            Console.WriteLine("Starting SoSe");
            //InjectedPropertyResolver.Resolve(this);

            RegisterProtobufParsers();
            SocketServerRegisterEvents();
            SocketServerStart();
        }

        private void SocketServerRegisterEvents()
        {
            Server = new WebSocketServer();
            Server.Connect("client_connected", this, "OnConnected");
            Server.Connect("client_disconnected", this, "OnDisconnected");
            Server.Connect("client_close_request", this, "OnCloseRequest");
            Server.Connect("data_received", this, "OnDataReceived");
        }

        private void RegisterProtobufParsers()
        {
            // TODO: avoid the creation of the bean manually...
            ProtobufSerializerService = new ProtobufSerializerService();
            ProtobufSerializerService.RegisterSerializer(typeof(SocketPushMessage), SocketPushMessage.Parser);
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

        private void OnConnected(int id, string protocol)
        {
            GD.Print($"Client {id} connected with protocol {protocol}");
            Server.GetPeer(id).SetWriteMode(WebSocketPeer.WriteMode.Binary);
        }

        private void OnDisconnected(int id, bool wasClean)
        {
            GD.Print($"Client {id} disconnected, clean {wasClean}");
        }

        private void OnCloseRequest(int id, int code, string reason)
        {
            GD.Print($"Client {id} disconnecting with code: {code}, reason: {reason}");
        }

        private void OnDataReceived(int id)
        {
            var data = Server.GetPeer(id).GetPacket();
            Type type = typeof(SocketPushMessage);
            SocketPushMessage socketPushMessage = (SocketPushMessage) ProtobufSerializerService.Deserialize(data, type);
            GD.Print(
                $"Got data from client {id}: Player: {socketPushMessage.PlayerId} and text: {socketPushMessage.Text}");
            Server.GetPeer(id).PutPacket(data);
        }


        public override void _ExitTree()
        {
            Server.Stop();
        }

        public override void _Process(float delta)
        {
            Server.Poll();
        }
    }
}