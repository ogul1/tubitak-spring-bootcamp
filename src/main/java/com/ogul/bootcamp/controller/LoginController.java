package com.ogul.bootcamp.controller;

import com.ogul.bootcamp.entity.dto.LoginRequest;
import com.ogul.bootcamp.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request) {
        return loginService.login(request);
    }

}
