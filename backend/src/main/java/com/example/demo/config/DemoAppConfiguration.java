package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableRetry
@EnableTransactionManagement
public class DemoAppConfiguration {}
