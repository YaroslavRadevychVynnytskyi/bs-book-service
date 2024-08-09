package com.application.bsbookservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class LoggerConfig {
    @Bean
    public Logger getLogger() {
        return Logger.getLogger("com.application.bsbookservice");
    }
}
