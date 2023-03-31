package com.example.gss.config.security;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .formLogin()//로그인 과정
                .loginProcessingUrl("/api/login")
                .usernameParameter("info1")
                .passwordParameter("info2")
                .and()
                .logout()// 로그아웃과정
                .logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
                .and()
                .anonymous()
                .disable()
                .csrf();
        return http.build();
    }

}
