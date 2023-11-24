//package com.example.rest_react_practice.Config.Configure;
//
//import org.jetbrains.annotations.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Deprecated
//@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
//@EnableGlobalMethodSecurity(securedEnabled = true) // @Secured 어노테이션 활성화
//@Configuration
//
//public class BoardConfiguration_TEST {
//
//    @Bean
//    public  WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(@NotNull CorsRegistry registry){
//                registry.addMapping("/api/**")
//                        .allowedOrigins("http://localhost:3000")  // React 애플리케이션의 주소
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
//                        .allowCredentials(true); // 비밀번호 인증 여부
//            }
//        };
//    }
//        @Autowired
//        private CustomUserDetailsService customUserDetailsService;
//
//        @Autowired
//        private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//        @Autowired
//        private JwtRequestFilter jwtRequestFilter;
//
//        @Bean
//        public PasswordEncoder passwordEncoder() {
//            return new BCryptPasswordEncoder();
//        }
//
//        @Autowired
//        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//        }
//
//        @Bean
//        protected void configure(HttpSecurity http) throws Exception {
//            http.csrf().disable()
//                    .authorizeRequests()
//                    .dispatcherTypeMatchers(HttpMethod.valueOf("/public/**")).permitAll()
//                    .dispatcherTypeMatchers(HttpMethod.valueOf("/admin/**")).hasRole("ADMIN")
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin()
//                    .loginPage("/login").permitAll()
//                    .and()
//                    .logout()
//                    .logoutUrl("/logout").permitAll()
//                    .and()
//                    .exceptionHandling()
//                    .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                    .and()
//                    .sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//            http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//        }
//    }
//
//
//
//
