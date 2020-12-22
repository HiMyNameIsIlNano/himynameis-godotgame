package com.example.demo.grpc.messageq.api;

import com.example.demo.grpc.messageq.GrpcChannelService;
import com.messageq.api.actions.PushMessageRequest;
import com.messageq.api.actions.QueueActionsGrpcServiceGrpc;
import com.messageq.api.actions.QueueActionsGrpcServiceGrpc.QueueActionsGrpcServiceBlockingStub;
import com.messageq.api.actions.QueueActionsGrpcServiceGrpc.QueueActionsGrpcServiceStub;
import com.messageq.api.actions.QueueMessage;
import io.grpc.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageQueueApiService {

    private final QueueActionsGrpcServiceBlockingStub blockingStub;

    private final QueueActionsGrpcServiceStub asyncStub;

    public MessageQueueApiService(GrpcChannelService grpcChannelService) {
        Channel channel = grpcChannelService.getChannel();
        this.blockingStub = QueueActionsGrpcServiceGrpc.newBlockingStub(channel);
        this.asyncStub = QueueActionsGrpcServiceGrpc.newStub(channel);
    }

    public void pushMessage(String exchangeName, String routingKey, QueueMessage message) {
        blockingStub.pushMessage(
                PushMessageRequest.newBuilder()
                        .setExchangeName(exchangeName)
                        .setRoutingKey(routingKey)
                        .setMessage(message)
                        .build());
    }
}
