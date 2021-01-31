package com.example.demo.grpc.messageq;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Getter
@Service
public class GrpcChannelService {

    @Value("${demo.messageq.address:localhost}")
    private String host;

    @Value("${demo.messageq.port:6565}")
    private int port;

    private Channel channel;

    @PostConstruct
    private void initChannelAndStub() {
        ManagedChannelBuilder<?> channelBuilder =
                ManagedChannelBuilder.forAddress(host, port).usePlaintext();
        this.channel = channelBuilder.build();
    }
}
