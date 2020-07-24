package com.example.demo.configuration;

import net.devh.boot.grpc.client.autoconfigure.GrpcClientAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.example.demo"})
@ImportAutoConfiguration({
    GrpcServerAutoConfiguration.class,
    GrpcServerFactoryAutoConfiguration.class,
    GrpcClientAutoConfiguration.class
})
public class GrpcIntegrationTestConfiguration {}
