package com.schnarbiesnmeowers.nmsmonolith.config;

import com.google.common.collect.ImmutableList;
import com.schnarbiesnmeowers.nmsmonolith.security.JwtAccessDeniedHandler;
import com.schnarbiesnmeowers.nmsmonolith.security.JwtAuthorizationFilter;
import com.schnarbiesnmeowers.nmsmonolith.security.JwtFailedAuth403MessageHandler;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
//@EnableWebFluxSecurity
//@EnableMethodSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration /*extends WebSecurityConfigurerAdapter*/ {

	private JwtAuthorizationFilter jwtAuthorizationFilter;
	private JwtAccessDeniedHandler jwtAccessDeniedHandler;
	private JwtFailedAuth403MessageHandler jwtAuthenticationEntryPoint;
	private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
	
	@Value("${cors.urls}")
	private String cors_urls;
	
	@Autowired
	public SecurityConfiguration(JwtAuthorizationFilter jwtAuthorizationFilter,
			JwtAccessDeniedHandler jwtAccessDeniedHandler, 
			JwtFailedAuth403MessageHandler jwtAuthenticationEntryPoint) {
		super();
		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
		this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
	}



	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.cors(corsCustomizer())
				.csrf(AbstractHttpConfigurer::disable)
				.sessionManagement(session -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(request -> request
						.requestMatchers(Constants.PUBLIC_URLS)
						.permitAll()
						.anyRequest()
						.authenticated())
				.exceptionHandling(exceptionHandling  -> exceptionHandling
						.accessDeniedHandler(this.jwtAccessDeniedHandler)
						.authenticationEntryPoint(this.jwtAuthenticationEntryPoint))
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
				//.cors()
				.build();

	}

	@Bean
	public Customizer<CorsConfigurer<HttpSecurity>> corsCustomizer() {
		return cors -> cors.configurationSource(corsConfigurationSource());  // Apply the CORS configuration source
	}



	@Bean
	public CorsConfigurer getCorsConfigurer() {
		return new CorsConfigurer();
	}

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		*//**
		 * tell it not to use cross-site request forgery
		 * tell it to use cross origin resource sharing
		 * configure a stateless session policy(no sessions)
		 * antMatchers : for these urls, you don't have to authenticate
		 *//*
		http.csrf(AbstractHttpConfigurer::disable)
		.cors()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests().antMatchers(Constants.PUBLIC_URLS).permitAll()
		.anyRequest().authenticated()
		.and()
		.exceptionHandling().accessDeniedHandler(this.jwtAccessDeniedHandler)
		.authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
		.and()
		.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
	}*/

	@Bean
	public AuthenticationManager authenticationManagerBean(UserDetailsService userDetailsService) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return new ProviderManager(daoAuthenticationProvider);
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        String[] urlsArray = cors_urls.split(",");
        System.out.println(urlsArray);
        configuration.setAllowedOrigins(Arrays.asList(urlsArray));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	
	@Bean
	public RestOperations restOperations() {
		return new RestTemplate();
	}
	
	
	private static void logAction(String message) {
    	System.out.println(message);
    	applicationLogger.debug(message);
    }
}
