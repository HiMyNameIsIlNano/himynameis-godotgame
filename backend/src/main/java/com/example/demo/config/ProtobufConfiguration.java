package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;

@Configuration
public class ProtobufConfiguration {

	@Bean
	ProtobufJsonFormatHttpMessageConverter protobufJsonFormatHttpMessageConverter() {
		return new ProtobufJsonFormatHttpMessageConverter();
	}

}
