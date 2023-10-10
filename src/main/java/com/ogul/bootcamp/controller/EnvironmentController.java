package com.ogul.bootcamp.controller;

import com.ogul.bootcamp.entity.Entity;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EnvironmentController {

    @PostMapping
    public Entity hello(@Valid @RequestBody Entity entity) {
        if (entity.getId().equals(1L)) {
            throw new RuntimeException("id cannot be 1");
        }
        return entity;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String sayHello() {
        return "<h1>Hello</h1>";
    }
}
