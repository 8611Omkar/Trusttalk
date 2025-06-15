package com.example.Trusttalk.config;

import com.example.Trusttalk.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ✅ new syntax for disabling CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**", "/server1/**").permitAll() // ✅ public endpoints
                        .anyRequest().authenticated() // ✅ all others need auth
                );

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // ✅ add custom JWT filter

        return http.build();
    }
}
