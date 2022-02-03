package com.weltio.challenge.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ConfiguracionRecursos extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		/***
		 * @author mdo
		 * se puede acceder sin autorizacion, para todo lo demos va a necesitar token de autorizacion
		 */
		http.authorizeRequests().antMatchers("/auth**").permitAll()
			.anyRequest().authenticated();
	}
	
}
