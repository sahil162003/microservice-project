package com.tp.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class RestTemplateConfig  {
    @Bean
    @LoadBalanced   // 🔥 REQUIRED for Eureka-based URL: http://PRODUCT-SERVICE/
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
