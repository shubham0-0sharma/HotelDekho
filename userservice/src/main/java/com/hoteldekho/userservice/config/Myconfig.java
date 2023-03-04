package com.hoteldekho.userservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Myconfig {
   @LoadBalanced 
    @Bean

    public RestTemplate getRestTemplateBean(){
        return new RestTemplate();
    }
}
