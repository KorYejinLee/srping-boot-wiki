package com.example.wiki;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
// 스프링의 환경 설정 파일임을 의미하는 애너테이션
// 스프링 시큐리티를 설정하기 위해 사용했다
@EnableWebSecurity
// 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션
// 이 애너테이션을 사용하면 스프링 시큐리티를 활성화하는 역할을 한다
// 내부적으로 SecurityFilterChain 클래스가 동작하여 모든 요청 URL에
// 이 클래스가 필터로 적용되어 URL별로 특별한 설정을 할 수 있게 된다.
// 스프링 시큐리티의 세부 설정은 @Bean 애너테이션을 통해 SecurityFilterChain 빈을 생성하여 설정할 수 있다
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
        ;

        return http.build();
    }
}