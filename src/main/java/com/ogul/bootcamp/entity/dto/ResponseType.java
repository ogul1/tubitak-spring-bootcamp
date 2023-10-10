package com.ogul.bootcamp.entity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ResponseType {

    SUCCESS(0),
    WARNING(1),
    ERROR(2);

    private final int code;

}
