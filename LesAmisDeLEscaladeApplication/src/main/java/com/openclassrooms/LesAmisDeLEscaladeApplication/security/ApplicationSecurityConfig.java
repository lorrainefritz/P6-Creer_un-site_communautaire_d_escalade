package com.openclassrooms.LesAmisDeLEscaladeApplication.security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.openclassrooms.LesAmisDeLEscaladeApplication.service.UserService;



@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	private final Logger logger = LoggerFactory.getLogger(ApplicationSecurityConfig.class);

	@Autowired
private UserService userService;
	
	@Bean 
public 	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("DANS LA CONFIGURATION DANS CONFIGURE DU AUTH MANAGER BUILDER JUSTE AVANT AUTHENTIFICATION PROVIDER");
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
			.csrf().disable()	
			.authorizeRequests()
				.antMatchers(
						"/",
						"/aProposDeLAssociation**",
						"/contact**",
						"/registration**",
						"/login**",
						"/listeDesSitesDEscalade",
						"/listeDesCommentaires",
						"/mentionsLegales**",
						"/imagesAndLogos/**",
						"/myScript.js",
						"/style.css",
						"/images/**",
						"/logos/**"
						).permitAll()
				.antMatchers(
						"/editUser",
						"/listeDesTopos",
						"/ajouterDesSitesDEscalade**",
						"/ajouterUnCommentaire",
						"/modifierUnTopo"
						).authenticated()

				.antMatchers("/listeDesUsers**","/editRole**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()

				.loginPage("/seConnecter") 
				.defaultSuccessUrl("/logSuccess")

				.permitAll()
				.and()
			.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/seConnecter?logout")
				.permitAll();

		
	}

}
