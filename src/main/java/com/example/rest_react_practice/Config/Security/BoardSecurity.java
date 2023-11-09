package com.example.rest_react_practice.Config.Security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.IpAddressMatcher;


@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@RequiredArgsConstructor
public class BoardSecurity {
//    @Bean
//    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//        http.authorizeHttpRequests(authorize -> {
//                    try {
//                        authorize
//                                .requestMatchers(WHITE_LIST).permitAll()
//                                .requestMatchers(PathRequest.toH2Console()).permitAll()
//                                .requestMatchers(new IpAddressMatcher("127.0.0.1")).permitAll()
//                                .and()
//                                .addFilter(getAuthenticationFilter());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//        );
//        return http.build();
//    }

}

