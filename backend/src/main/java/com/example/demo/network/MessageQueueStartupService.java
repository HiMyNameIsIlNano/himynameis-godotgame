package com.example.demo.network;

import com.messageq.config.ExchangeCreationRequest;
import com.messageq.config.ExchangeCreationResponse;
import com.messageq.config.ManageQueueGrpcServiceGrpc;
import com.messageq.config.ManageQueueGrpcServiceGrpc.ManageQueueGrpcServiceBlockingStub;
import com.messageq.config.ManageQueueGrpcServiceGrpc.ManageQueueGrpcServiceStub;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@NoArgsConstructor
@Service
@Slf4j
public class MessageQueueStartupService {

    @Value("${demo.messageq.address:localhost}")
    private String host;

    @Value("${demo.messageq.port:6565}")
    private int port;

    @Value("${demo.messageq.exchanges.push-notification}")
    private String pushNotificationExchangeName;

    private ManageQueueGrpcServiceBlockingStub blockingStub;

    private ManageQueueGrpcServiceStub asyncStub;

    public MessageQueueStartupService(ManageQueueGrpcServiceBlockingStub blockingStub, ManageQueueGrpcServiceStub asyncStub) {
        this.blockingStub = blockingStub;
        this.asyncStub = asyncStub;
    }

    @PostConstruct
    private void initChannelAndStub() {
        ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress(host, port).usePlaintext();
        Channel channel = channelBuilder.build();
        this.blockingStub = ManageQueueGrpcServiceGrpc.newBlockingStub(channel);
        this.asyncStub = ManageQueueGrpcServiceGrpc.newStub(channel);
    }

    public void buildMessagePushQueueExchange() {
        try {
            ExchangeCreationResponse exchange = blockingStub.createExchange(ExchangeCreationRequest.newBuilder()
                    .setExchangeName(pushNotificationExchangeName)
                    .build());

            log.info(exchange.toString());
        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {}", e.getStatus());
        }
    }
}
