package com.ogul.bootcamp.entity.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class MessageResponse {

    private final String message;
    private final ResponseType responseType;
}
