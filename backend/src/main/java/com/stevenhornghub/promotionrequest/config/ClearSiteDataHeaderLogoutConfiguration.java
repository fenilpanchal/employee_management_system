//package com.stevenhornghub.promotionrequest.config;
//
//import javax.servlet.ServletException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@Slf4j
//public class ClearSiteDataHeaderLogoutConfiguration {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                //.securityMatchers("/request/**")
//                .authorizeHttpRequests(authz -> authz.anyRequest().permitAll())
//                .logout(logout -> logout.logoutUrl("/request/logout")
//                    .addLogoutHandler((request, response, auth) -> {
//                        try {
//                            request.logout();
//                        } catch (ServletException e) {
//                            log.error(e.getMessage());
//                        }
//                    }));
//        return http.build();
//    }
//}