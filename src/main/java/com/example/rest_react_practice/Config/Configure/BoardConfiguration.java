package com.example.rest_react_practice.Config.Configure;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
    public class BoardConfiguration {

    @Bean
    public  WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull CorsRegistry registry){
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:3000")  // React 애플리케이션의 주소
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                        .allowCredentials(true); // 비밀번호 인증 여부
            }
        };
    }

}



