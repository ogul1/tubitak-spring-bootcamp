package com.ogul.bootcamp.controller;

import com.ogul.bootcamp.entity.dto.MessageResponse;
import com.ogul.bootcamp.entity.dto.ResponseType;
import com.ogul.bootcamp.entity.dto.SignInRequest;
import com.ogul.bootcamp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DashboardController {

    private final UserService userService;

    @GetMapping
    public String dashboard() {
        return "This is the dashboard.";
    }

    @PostMapping("/sign-in")
    public MessageResponse signIn(@Valid @RequestBody SignInRequest request) {
        userService.signIn(request);
        return MessageResponse.builder()
            .message("Signed in successfully.")
            .responseType(ResponseType.SUCCESS)
            .build();
    }

    @DeleteMapping("/user/{id}")
    public MessageResponse deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return MessageResponse.builder()
            .message("Removed user with id " + id)
            .responseType(ResponseType.SUCCESS)
            .build();
    }

}
