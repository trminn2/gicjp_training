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

/**
 * The Class SecurityConfig.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class SecurityConfig.
 */
@EnableWebSecurity
@Configuration
@ComponentScan("com.gic.ems")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/** The service. */
	@Autowired
	@Qualifier("m01_ServiceImpl")
	private UserDetailsService service;

	/**
	 * Gets the password encoder.
	 *
	 * @return the password encoder
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/** The Constant PERMIT_ALL. */
	private static final String[] PERMIT_ALL = { "/static/**" };

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(PERMIT_ALL).permitAll().anyRequest().authenticated();
		http.formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/home")
				.usernameParameter("email").passwordParameter("password").permitAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(this.getPasswordEncoder());
		provider.setUserDetailsService(this.service);
		auth.authenticationProvider(provider);
	}
}