package com.example.demo.grpc.messageq.api;

import com.example.demo.grpc.messageq.GrpcChannelService;
import com.messageq.api.actions.PushMessageRequest;
import com.messageq.api.actions.QueueActionsGrpcServiceGrpc;
import com.messageq.api.actions.QueueActionsGrpcServiceGrpc.QueueActionsGrpcServiceBlockingStub;
import com.messageq.api.actions.QueueActionsGrpcServiceGrpc.QueueActionsGrpcServiceStub;
import com.messageq.api.actions.QueueMessage;
import io.grpc.Channel;
import javax.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Slf4j
@Service
public class MessageQueueApiService {

    @Autowired private GrpcChannelService grpcChannelService;

    private QueueActionsGrpcServiceBlockingStub blockingStub;

    private QueueActionsGrpcServiceStub asyncStub;

    public MessageQueueApiService(
            QueueActionsGrpcServiceBlockingStub blockingStub,
            QueueActionsGrpcServiceStub asyncStub) {
        this.blockingStub = blockingStub;
        this.asyncStub = asyncStub;
    }

    @PostConstruct
    private void initStubs() {
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
