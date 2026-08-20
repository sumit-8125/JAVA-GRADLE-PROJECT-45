package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class DashboardController {

    @GetMapping("/api/status")
    public Map<String, Object> status() {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("application", "DevOps Build Dashboard");
        response.put("status", "RUNNING");
        response.put("version", "1.0.0");
        response.put("build", "SUCCESS");
        response.put("tests", "PASSED");
        response.put("java", "21");
        response.put("gradle", "BUILD TOOL");
        response.put("jenkins", "CI/CD");
        response.put("docker", "CONTAINERIZATION");

        return response;
    }
}