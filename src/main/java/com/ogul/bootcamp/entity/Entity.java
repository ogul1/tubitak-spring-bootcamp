package com.ogul.bootcamp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Entity {

    @Max(20)
    private Long id;

    @NotBlank
    @JsonProperty("username")
    private String name;
}
