using Com.Example.Demo.Protobuf.Socket;
using Godot;

namespace Com.Example.Game
{
    public class SocketServerButton : Button
    {
            private const int Port = 4444;

            private WebSocketServer _server;

            public override void _Ready()
            {
                _server = new WebSocketServer();
            }

            public override void _Pressed()
            {
                _server.Connect("client_connected", this, "OnConnected");
                _server.Connect("client_disconnected", this, "OnDisconnected");
                _server.Connect("client_close_request", this, "OnCloseRequest");
                _server.Connect("data_received", this, "OnDataReceived");

                Error error = _server.Listen(Port);
                if (error != Error.Ok)
                {
                    GD.PrintErr("Unable to start the server");
                    SetProcess(false);
                }

                GD.Print($"Socket Server listening on port {Port}");
            }

            private void OnConnected(int id, string protocol)
            {
                GD.Print($"Client {id} connected with protocol {protocol}");
                _server.GetPeer(id).SetWriteMode(WebSocketPeer.WriteMode.Binary);
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
                byte[] packet = _server.GetPeer(id).GetPacket();
                SocketPushMessage socketPushMessage = SocketPushMessage.Parser.ParseFrom(packet);
                GD.Print(
                    $"Got data from client {id}: Player: {socketPushMessage.PlayerId} and text: {socketPushMessage.Text}");
                _server.GetPeer(id).PutPacket(packet);
            }

            public override void _Process(float delta)
            {
                _server.Poll();
            }

            public override void _ExitTree()
            {
                _server.Stop();
            }
        
    }
}