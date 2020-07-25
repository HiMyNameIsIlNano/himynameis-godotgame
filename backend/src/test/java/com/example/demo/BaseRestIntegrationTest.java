package com.example.demo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"no-security"})
public abstract class BaseRestIntegrationTest extends BaseIntegrationTest {

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder()
                .additionalMessageConverters(new ProtobufJsonFormatHttpMessageConverter());
    }
}
