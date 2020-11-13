package com.example.demo.grpc.messageq.startup;

import com.example.demo.grpc.messageq.GrpcChannelService;
import com.messageq.api.creation.ExchangeCreationRequest;
import com.messageq.api.creation.ExchangeCreationResponse;
import com.messageq.api.creation.ManageQueueGrpcServiceGrpc;
import com.messageq.api.creation.ManageQueueGrpcServiceGrpc.ManageQueueGrpcServiceBlockingStub;
import com.messageq.api.creation.ManageQueueGrpcServiceGrpc.ManageQueueGrpcServiceStub;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import javax.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// TODO: this is not called by the Back End at startup
@NoArgsConstructor
@Service
@Slf4j
public class MessageQueueStartupService {

    @Autowired private GrpcChannelService grpcChannelService;

    @Value("${demo.messageq.exchanges.push-notification.rewards.exchange-name}")
    private String pushNotificationExchangeName;

    private ManageQueueGrpcServiceBlockingStub blockingStub;

    private ManageQueueGrpcServiceStub asyncStub;

    public MessageQueueStartupService(
            ManageQueueGrpcServiceBlockingStub blockingStub, ManageQueueGrpcServiceStub asyncStub) {
        this.blockingStub = blockingStub;
        this.asyncStub = asyncStub;
    }

    @PostConstruct
    private void initStubs() {
        Channel channel = grpcChannelService.getChannel();
        this.blockingStub = ManageQueueGrpcServiceGrpc.newBlockingStub(channel);
        this.asyncStub = ManageQueueGrpcServiceGrpc.newStub(channel);
    }

    public void buildMessagePushQueueExchange() {
        try {
            ExchangeCreationResponse exchange =
                    blockingStub.createExchange(
                            ExchangeCreationRequest.newBuilder()
                                    .setExchangeName(pushNotificationExchangeName)
                                    .build());

            log.info(exchange.toString());
        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {}", e.getStatus());
        }
    }
}
