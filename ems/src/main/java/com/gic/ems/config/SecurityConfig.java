package com.gic.ems.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@ComponentScan("com.gic.ems")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("m01_ServiceImpl")
	private UserDetailsService service;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private static final String[] PERMIT_ALL = { "/js/**", "/css/**", "/img/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(PERMIT_ALL).permitAll().anyRequest().authenticated();
		http.formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/home")
				.usernameParameter("email").passwordParameter("password").permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(this.getPasswordEncoder());
		provider.setUserDetailsService(this.service);
	}
}