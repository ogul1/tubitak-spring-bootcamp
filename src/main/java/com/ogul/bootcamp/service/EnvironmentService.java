package com.ogul.bootcamp.service;

import com.ogul.bootcamp.configuration.EnvironmentProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnvironmentService {

    private final EnvironmentProperties environmentProperties;

    public void printList() {
        System.out.println(environmentProperties.getProperty());
        System.out.println(environmentProperties.getStringList());
    }
}
