package com.ecouv.EcoUv.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // para probar endpoints POST sin token
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()   // TODO: luego restringimos
            )
            .httpBasic(Customizer.withDefaults()); // no afecta porque todo está abierto
        return http.build();
    }
}
