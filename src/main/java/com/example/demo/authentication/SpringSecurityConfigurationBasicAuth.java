package com.example.demo.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth
//extends WebSecurityConfigurerAdapter 
{

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest()
//				.authenticated().and().httpBasic();
//	}

}

//http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
//http.formLogin();
//http.httpBasic();
//
