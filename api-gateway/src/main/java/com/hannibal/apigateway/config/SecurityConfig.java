package com.hannibal.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFluxSecurity
@EnableWebFlux
public class SecurityConfig implements WebFluxConfigurer {
        @Bean
        public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
                return http
                                .httpBasic().disable()
                                .build();
        }

        @Override
        public void addCorsMappings(CorsRegistry corsRegistry) {
                corsRegistry.addMapping("/**")
                                .allowedOrigins("http://localhost:4200")
                                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                                .maxAge(3600);
        }

}