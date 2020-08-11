using System;
using Godot;

public class SocketServerButton : Godot.Button
{
    private const int Port = 4444;
    private const string SocketServerAddress = "127.0.0.1";

    private Boolean _done;
    private PacketPeerUDP _socket;

    public override void _Ready()
    {
        _socket = new PacketPeerUDP();
    }

    public override void _Pressed()
    {
        if (_socket.Listen(Port, SocketServerAddress) != Error.Ok)
        {
            GD.Print("An error occurred while listening on port ", Port);
            _done = true;
        }
        else
        {
            GD.Print("Listening on port ", Port);
        }

        while (!_done)
        {
            if (_socket.GetAvailablePacketCount() <= 0)
            {
                continue;
            }

            ReadReceivedDataAndPrint();
        }


        _socket.Close();
        GD.Print("Exiting application");
    }

    private void ReadReceivedDataAndPrint()
    {
        var data = _socket.GetPacket().ToString();
        _done = data == "quit";
        if (!_done)
        {
            GD.Print("Data received: ", data);
        }
    }
}