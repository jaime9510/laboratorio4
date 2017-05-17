package it.polito.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import it.polito.ai.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsServiceImpl);
		
//		auth.inMemoryAuthentication().
//			withUser("user").
//			password("pass").
//			roles("USER").
//		and().
//			withUser("admin").
//			password("admin").
//			roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/","/user/registration","/home", "/css/**").permitAll()
				.anyRequest().authenticated()
//				.anyRequest().permitAll()
//				.antMatchers("/admin/**").hasRole("ADMIN")
//				.antMatchers("/**").hasRole("USER")
			.and()
				.formLogin()
					.loginPage("/login")
	                .permitAll()
	                .defaultSuccessUrl("/")
	                .and()
	            .logout()
	                .permitAll()
	        .and()
	            .httpBasic()
//	        .and()
//	            .csrf()
	         /*.and()
					.csrf()
					.disable()*/;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		
		
		
	}
	
	

}
