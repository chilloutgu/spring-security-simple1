package me.chillgu.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.authenticationProvider(authenticationProvider()); }
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/my").authenticated()
				.anyRequest().permitAll()
				.and()
			.formLogin()
				.and()
			.httpBasic();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder( ) {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	/*
	 * @Bean public AuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider authenticationProvider = new
	 * DaoAuthenticationProvider();
	 * authenticationProvider.setPasswordEncoder(passwordEncoder()); return
	 * authenticationProvider; }
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { PasswordEncoder
	 * passwordEncoder = new BCryptPasswordEncoder();
	 * 
	 * return passwordEncoder; }
	 */
}
