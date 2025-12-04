package com.vidaplus.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())               // Desativa proteção CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()           // Libera todas as rotas
                )
                .formLogin(form -> form.disable())          // Desativa login padrão
                .httpBasic(basic -> basic.disable());       // Desativa autenticação básica

        return http.build();
    }
}
