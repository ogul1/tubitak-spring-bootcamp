package com.ogul.bootcamp.configuration;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "custom")
public class EnvironmentProperties {

    private List<Integer> property;
    private List<String> stringList;

}
