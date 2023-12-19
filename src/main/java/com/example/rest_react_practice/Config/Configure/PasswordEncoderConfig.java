package com.example.rest_react_practice.Config.Configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
    // UserInfoService가 passwordEncoder 클래스를 의존하기 때문에 이것을 SecurityConfig 내부에 구현하면 SecurityConfig까지 의존하여 순환 참조 오류가 발생한다.
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
