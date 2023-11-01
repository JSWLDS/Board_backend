package com.example.rest_react_practice.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration

public class ConfigurationDemo implements WebMvcConfigurer {
    @Bean
    public  WebMvcConfigurer corsConfigurer() {
     return new WebMvcConfigurer() {
         @Override
         public void addCorsMappings(CorsRegistry registry){
             registry.addMapping("/api/**")
                     .allowedOrigins("http://localhost:3000")  // React 애플리케이션의 주소
                     .allowedMethods("GET", "POST", "PUT", "DELETE")
                     .allowCredentials(true);
         }
     };
    }
}
