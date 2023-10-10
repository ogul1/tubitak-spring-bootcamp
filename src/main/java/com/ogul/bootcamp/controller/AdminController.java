package com.ogul.bootcamp.controller;

import com.ogul.bootcamp.entity.dto.MessageResponse;
import com.ogul.bootcamp.entity.dto.ResponseType;
import com.ogul.bootcamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @PostMapping("/{id}")
    public MessageResponse giveAdminRights(@PathVariable Long id) {
        userService.giveAdminRights(id);
        return MessageResponse.builder()
            .message("Admin rights given.")
            .responseType(ResponseType.SUCCESS)
            .build();
    }
}
