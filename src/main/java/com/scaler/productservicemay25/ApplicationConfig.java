package com.scaler.productservicemay25;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@Component also can eb used, but @Configuration is better for readability

@Configuration
public class ApplicationConfig {

    @Bean
    public RestTemplate createRestTemplateBean() {
        return new RestTemplate();
    }
}
