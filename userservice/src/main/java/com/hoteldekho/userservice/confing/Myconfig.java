package com.hoteldekho.userservice.confing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Myconfig {
    @Bean
    public RestTemplate getRestTemplateBean(){
        return new RestTemplate();
    }
}
