package com.telcal.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		return new CorsConfigurationSource() {
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowCredentials(true);
				config.addAllowedMethod("*");
				config.addAllowedHeader("*");
				config.setMaxAge(3600L);
				config.addAllowedOrigin(request.getHeader("Origin"));
				return config;
			}
		};
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOriginPatterns("*://*/*").allowedMethods("*").allowedHeaders("*")
				.exposedHeaders("Location", "Content-Disposition", "Content-Type", "Accept", "Authorization")
				.maxAge(3600).allowCredentials(true);
	}
}