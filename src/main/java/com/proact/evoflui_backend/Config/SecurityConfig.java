package com.proact.evoflui_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Desabilita CSRF, útil para APIs REST
                .authorizeHttpRequests()
                .anyRequest().permitAll() // Permite acesso irrestrito a todas as rotas
                .and()
                .formLogin().disable(); // Desabilita o formulário de login padrão

        return http.build();  // Retorna a configuração de segurança
    }
}
