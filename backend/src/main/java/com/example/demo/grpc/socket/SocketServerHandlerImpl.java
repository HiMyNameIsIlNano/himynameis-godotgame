package com.example.demo.grpc.socket;

import com.example.demo.common.socket.SocketServerComponentHandler;
import com.example.demo.protobuf.SocketPush.SocketConnectionResponse;
import com.example.demo.protobuf.SocketServerGrpcServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@RequiredArgsConstructor
@GrpcService
public class SocketServerHandlerImpl
        extends SocketServerGrpcServiceGrpc.SocketServerGrpcServiceImplBase {

    private final SocketServerComponentHandler socketServerComponentHandler;

    @Override
    public void connectToServer(
            Empty request, StreamObserver<SocketConnectionResponse> responseObserver) {
        try {
            socketServerComponentHandler.connectToSocketServer();
        } catch (ExecutionException | InterruptedException e) {
            responseObserver.onError(Status.ABORTED.asException());
        }
    }
}
