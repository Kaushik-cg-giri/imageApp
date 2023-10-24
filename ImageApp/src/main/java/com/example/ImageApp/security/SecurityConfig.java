//package com.example.ImageApp.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.access.intercept.AuthorizationFilter;
//import org.springframework.security.web.authentication.AuthenticationFilter;
//import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//
//
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//	//authentication
//	@Bean
//	public UserDetailsService userDetailsService(){
//
//
//		//If user name and passsword is hardcoded we can use this method for authentication
//
//		 /* UserDetails user= User.withUsername("kaushik")
//		  .password(encoder.encode("123")) .roles("user") .build(); return new
//		  InMemoryUserDetailsManager(user);*/
//
//		 return new customUserDetailsService();
//
//	}
//
//	//authorization
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//		return http.authorizeHttpRequests()
//	            .requestMatchers(AntPathRequestMatcher.antMatcher("/add/user")).permitAll()
//	            .and()
//	            .csrf().ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/add/user"))
//	            .and()
//	            .formLogin()
//	            .and()
//	            .headers(headers -> headers.frameOptions().sameOrigin())
//	            .build();
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//		return daoAuthenticationProvider;
//	}
//}
//
