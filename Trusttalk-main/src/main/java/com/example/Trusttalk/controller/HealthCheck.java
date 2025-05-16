package com.example.Trusttalk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    
    @GetMapping
    public String healthCheck(){git 
        return "ok";
    }
    
}