package com.wrd.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {
	
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAware<String>() {
			
			@Override
			public Optional<String> getCurrentAuditor() {
				// TODO Auto-generated method stub
				return Optional.of("TempUser");
			}
		};
	}
	
}
