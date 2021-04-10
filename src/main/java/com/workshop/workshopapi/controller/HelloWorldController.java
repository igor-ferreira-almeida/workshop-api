package com.workshop.workshopapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    @Value("${application.name}")
    private String applicationName2;

    @GetMapping("/hello")
    public String helloWorld() {
        System.out.println(System.getenv("environment"));
        return applicationName2 + ", Hello World!";
    }
}
