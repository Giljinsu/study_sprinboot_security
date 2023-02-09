package com.example.study_sprinboot_security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// spring이 실행될때 알아서 호출함
@Configuration
public class SecurityConfiguration {
    // @Bean //클래스가 아닌 메소드를 인스턴스화 시킴 
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // url & roles : users url & roles
        httpSecurity.authorizeRequests()
            // .antMatchers("/").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
            .antMatchers("/").authenticated() // 로그인 했는지 확인
            .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
            .anyRequest().permitAll(); // 설정한 url 이외는 접근 가능
            
            //로그인 대한 부분
            httpSecurity.formLogin().loginPage("/loginForm")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/");
        return httpSecurity.build();
    }
}
