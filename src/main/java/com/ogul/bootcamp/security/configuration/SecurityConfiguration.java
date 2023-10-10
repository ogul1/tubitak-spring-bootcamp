package com.ogul.bootcamp.security.configuration;

import com.ogul.bootcamp.security.service.CustomAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login").permitAll()
                .requestMatchers("/sign-in").permitAll()
                .requestMatchers("/admin/**").permitAll()
                .requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/api/v1/**").hasRole("ADMIN")
                .anyRequest().authenticated())
            .csrf(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)
            .logout(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.requireExplicitAuthenticationStrategy(false))
            .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(CustomAuthenticationProvider customAuthenticationProvider) {
        return new ProviderManager(customAuthenticationProvider);
    }

    @Bean
    public RequestAttributeSecurityContextRepository requestAttributeSecurityContextRepository() {
        return new RequestAttributeSecurityContextRepository();
    }

    @Bean
    public HttpSessionSecurityContextRepository httpSessionSecurityContextRepository() {
        return new HttpSessionSecurityContextRepository();
    }

    @Bean
    public SecurityContextRepository securityContextRepository(RequestAttributeSecurityContextRepository requestAttributeSecurityContextRepository,
                                                               HttpSessionSecurityContextRepository httpSessionSecurityContextRepository) {
        return new DelegatingSecurityContextRepository(requestAttributeSecurityContextRepository, httpSessionSecurityContextRepository);
    }
}
