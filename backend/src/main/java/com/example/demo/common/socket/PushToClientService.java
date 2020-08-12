package com.example.demo.common.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Service
public class PushToClientService extends TextWebSocketHandler {

    @Value("${demo.socket-server.address:localhost}")
    private String udpSocketServerAddress;

    @Value("${demo.socket-server.port:4444}")
    private int udpSocketServerPort;

    private final InetAddress UDP_SOCKET_SERVER_INET_ADDRESS = InetAddress.getByName(
            udpSocketServerAddress);

    private final DatagramSocket socket;

    public PushToClientService() throws SocketException, UnknownHostException {
        this.socket = new DatagramSocket();
    }

    public void pushToClient(String text) throws IOException {
        byte[] data = text.getBytes();
        DatagramPacket packet =
                new DatagramPacket(data, data.length, UDP_SOCKET_SERVER_INET_ADDRESS,
                        udpSocketServerPort);
        socket.send(packet);
    }

    public void closeConnectionToUDPSocket() {
        socket.close();
    }
}
