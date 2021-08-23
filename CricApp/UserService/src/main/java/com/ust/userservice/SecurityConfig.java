package com.ust.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().csrf().disable().authorizeRequests()
              .antMatchers("/u/cricapp/p/**").permitAll()
				.antMatchers("/u/cricapp/user/**").hasAnyRole("ADMIN", "USER")
//               .antMatchers("/**").permitAll()
				.and().formLogin();
//        http.csrf().disable();
//	httpBasic() this one is fot GET in post man and csrf().disable() this for POST	 
	}

	@Bean
	public PasswordEncoder getpassPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();

	}

}
