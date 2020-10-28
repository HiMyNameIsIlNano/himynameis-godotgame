package com.example.demo.network;

import com.example.demo.grpc.GrpcChannelService;
import com.messageq.config.ExchangeCreationRequest;
import com.messageq.config.ExchangeCreationResponse;
import com.messageq.config.ManageQueueGrpcServiceGrpc;
import com.messageq.config.ManageQueueGrpcServiceGrpc.ManageQueueGrpcServiceBlockingStub;
import com.messageq.config.ManageQueueGrpcServiceGrpc.ManageQueueGrpcServiceStub;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import javax.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
@Slf4j
public class MessageQueueStartupService {

    @Autowired private GrpcChannelService grpcChannelService;

    @Value("${demo.messageq.exchanges.push-notification}")
    private String pushNotificationExchangeName;

    private ManageQueueGrpcServiceBlockingStub blockingStub;

    private ManageQueueGrpcServiceStub asyncStub;

    public MessageQueueStartupService(
            ManageQueueGrpcServiceBlockingStub blockingStub, ManageQueueGrpcServiceStub asyncStub) {
        this.blockingStub = blockingStub;
        this.asyncStub = asyncStub;
    }

    @PostConstruct
    private void initChannelAndStub() {
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
