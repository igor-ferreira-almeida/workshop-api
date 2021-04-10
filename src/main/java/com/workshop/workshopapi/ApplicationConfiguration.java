package com.workshop.workshopapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean(name = "applicationName")
    public String applicationName() {
        return "Workshop";
    }
}
