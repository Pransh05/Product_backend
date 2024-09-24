package com.productmanagement.ProductManagement.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Priya
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF protection using lambda syntax
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/products/**").permitAll()  // Allow access to /api/products/** without authentication
                        .anyRequest().authenticated()  // All other requests require authentication
                );

        return http.build();
    }
}
