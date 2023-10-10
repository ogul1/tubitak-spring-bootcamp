package com.ogul.bootcamp.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomErrorFormat {

    private Long id;
    private Integer errorCode;
    private String message;
}
