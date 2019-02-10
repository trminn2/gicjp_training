package com.gic.ems.config;

import java.util.Arrays;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gic.ems.common.constant.MessageConstant;
import com.gic.ems.common.utility.MessageUtility;
import com.gic.ems.entity.User;
import com.gic.ems.service.impl.M01_ServiceImpl;

import lombok.NonNull;

/**
 * The Class SecurityConfig.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Jan 26, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.config </BR>
 *        SecurityConfig.java </BR>
 */
@EnableWebSecurity
@Configuration
@ComponentScan("com.gic.ems")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/** The service. */
	private M01_ServiceImpl service;

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	@Autowired
	public void setService(M01_ServiceImpl service) {
		this.service = service;
	}

	/** The message utility. */
	private MessageUtility messageUtility;

	/**
	 * Sets the message utility.
	 *
	 * @param messageUtility the new message utility
	 */
	@Autowired
	public void setMessageUtility(MessageUtility messageUtility) {
		this.messageUtility = messageUtility;
	}

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
	private static final String[] PERMIT_ALL = { "/static/**", "/login" };

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(SecurityConfig.PERMIT_ALL).permitAll().anyRequest().authenticated();
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
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.springframework.security.authentication.dao.
			 * AbstractUserDetailsAuthenticationProvider#authenticate(org.springframework.
			 * security.core.Authentication)
			 */
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				if (StringUtils.isBlank(authentication.getName())) {
					String requiredMessage = SecurityConfig.this.messageUtility.getMessage(MessageConstant.REQUIRED,
							MessageConstant.EMAIL);
					throw new UsernameNotFoundException(requiredMessage);
				} else if (!ObjectUtils.anyNotNull(authentication.getCredentials())
						| StringUtils.isBlank(authentication.getCredentials().toString())) {
					String requiredMessage = SecurityConfig.this.messageUtility.getMessage(MessageConstant.REQUIRED,
							MessageConstant.PASSWORD);
					throw new BadCredentialsException(requiredMessage);
				} else {
					try {
						return super.authenticate(authentication);
					} catch (BadCredentialsException e) {
						throw new BadCredentialsException(
								SecurityConfig.this.messageUtility.getMessage(MessageConstant.APP_BADCREDENTIAL));
					}
				}
			}

			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.springframework.security.authentication.dao.DaoAuthenticationProvider#
			 * setPasswordEncoder(org.springframework.security.crypto.password.
			 * PasswordEncoder)
			 */
			@Override
			public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
				super.setPasswordEncoder(SecurityConfig.this.getPasswordEncoder());
			}
		};
		provider.setUserDetailsService((@NonNull String email) -> {
			User user = SecurityConfig.this.service.findByEmail(email);
			if (!ObjectUtils.anyNotNull(user)) {
				throw new UsernameNotFoundException(MessageConstant.USER_NOT_FOUND);
			}
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true,
					true, true, true, Arrays.asList(new SimpleGrantedAuthority(user.getRole().toString())));
		});
		auth.authenticationProvider(provider);
	}
}