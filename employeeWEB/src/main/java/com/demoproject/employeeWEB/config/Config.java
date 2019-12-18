package com.demoproject.employeeWEB.config;

import com.demoproject.employeeWEB.service.APIClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;



@Configuration
public class Config {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    APIClientService apiClientService(RestTemplate restTemplate) {
        return new APIClientService(restTemplate);
    }



}


