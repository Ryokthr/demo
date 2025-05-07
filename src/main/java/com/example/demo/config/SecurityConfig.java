package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
					.requestMatchers(HttpMethod.POST, "/api/**").hasAnyRole("USER", "ADMIN").requestMatchers("/**")
					.authenticated();
		}).formLogin((fromLogin) -> {
			fromLogin.loginPage("/login").failureUrl("/login?failure").defaultSuccessUrl("/main", true).permitAll();
		}).exceptionHandling((exceptionHandling) -> {
			exceptionHandling.accessDeniedPage("/access-denied");
		});

		return http.build();
	}

	/**
	 * TODO とりあえずInMemoryでdbに認証情報を格納したい。
	 */
	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails member = User.builder().username("member").password("{noop}password").roles("USER").build();
		UserDetails admin = User.builder().username("admin").password("{noop}password").roles("ADMIN").build();

		return new InMemoryUserDetailsManager(member, admin);
	}
}
