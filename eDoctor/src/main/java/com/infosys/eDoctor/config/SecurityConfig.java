package com.infosys.eDoctor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(authz -> authz
<<<<<<< HEAD
                        .anyRequest().permitAll()) // Allow all requests
=======
                        .requestMatchers(
                                "/addUser",
                                "/loginUser",
                                "/doctor/addDoctor",
                                "/patient/addPatient",
                                "/patient/login",
                                "/availability/**"
                        ).permitAll()
                        .anyRequest().authenticated())
>>>>>>> cf5a0064cbc3cb72d1577d23d9215595507e9484
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll());
        return http.build();
    }
}
