package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author kitahararyou
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((authorizeHttpRequests) -> {
			authorizeHttpRequests.requestMatchers("/css/**", "/js/**", "/images/").permitAll()
					.requestMatchers(HttpMethod.POST, "/api/**").hasAnyRole("USER").requestMatchers("/**")
					.hasRole("USER").anyRequest().permitAll();
		}).formLogin((fromLogin) -> {
			fromLogin.loginPage("/login").failureUrl("/login?failure").defaultSuccessUrl("/main").permitAll();
		});

		return http.build();
	}
}
