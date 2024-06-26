package com.recipemanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.recipemanagement.security.jwt.JwtEntryPoint;
import com.recipemanagement.security.jwt.JwtFilter;
import com.recipemanagement.services.UserDetailsServiceImpl;

@Configuration
// @EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	// acts as medium to extract user information and pass to the repository,
	// database
	@Autowired
	UserDetailsServiceImpl userService;
	@Autowired
	private JwtEntryPoint unauthorizedHandler;

	@Bean
	public JwtFilter authenticationJwtTokenFilter() {
		return new JwtFilter();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/login", "/register", "/recipes", "/recipes/add", "/recipes/**")
								.permitAll()
								.anyRequest())
				.formLogin(form -> form.loginPage("/")
						// .usernameParameter("email")
						// .passwordParameter("password")
						.defaultSuccessUrl("/recipes")
						.permitAll())
				.logout(logout -> logout.permitAll());

		http.authenticationProvider(authenticationProvider());

		http.addFilterBefore(authenticationJwtTokenFilter(),
				UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
