package com.candidate.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.candidate.service.impl.CustomeUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
@EnableJpaRepositories(basePackages="com.candidate.repository")
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

	@Autowired
	private CustomeUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("SecurityConfiguration.configure() ");
		auth.userDetailsService(userDetailsService).passwordEncoder(getPassword());
	}

	private PasswordEncoder getPassword() {
		return new PasswordEncoder() {
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return true;
			}
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}
		};
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/").authenticated().and()
				.formLogin().permitAll().defaultSuccessUrl("/candidate/getAllCandidates", true).and()
		          .logout()
		          .logoutUrl("/logout")
		          .deleteCookies("JSESSIONID");
	}
}
