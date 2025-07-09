package com.aryan.culinary_craft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/culinary-craft/health")
public class HealthCheckController {
    @GetMapping
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Culinary Craft is up and running!");
    }
}
