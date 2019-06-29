package com.oliveira.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter
{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		// add our users for in memory authentication

		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("jhon").password("test123").roles("EMPLOYEE"));
		auth.inMemoryAuthentication().withUser(users.username("mary").password("test123").roles("MANAGER"));
		auth.inMemoryAuthentication().withUser(users.username("susan").password("test123").roles("ADMIN"));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		// Configure security of web paths in application, login, logout etc

		http.authorizeRequests() // restrict access based on the HttpServeletRequest
						.anyRequest().authenticated() // any request to the app must be authenticated (ie logged in)
						.and()
						.formLogin() // we are customizing the form login process
						.loginPage("/showMyLoginPage") // show our custom form at the request mapping "/showMyLoginPage"
						.loginProcessingUrl("/authenticateTheUser") // login form should POST data to this URL for processing (check user id and passowrd)
						.permitAll() // allow everyone to see login page, no need to be logged in
						.and()
						.logout() // add logout support for default URL /logout
						.permitAll(); // allow everyone to see logout page
	}

}
