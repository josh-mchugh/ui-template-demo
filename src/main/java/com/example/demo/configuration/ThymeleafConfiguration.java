package com.example.demo.configuration;

import ch.mfrey.thymeleaf.extras.with.WithDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfiguration {

    @Bean
    public WithDialect withDialect() {
        
        return new WithDialect();
    }
}
