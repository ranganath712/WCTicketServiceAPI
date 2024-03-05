package com.wc.ts.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {
	
	@Bean
	GroupedOpenApi handleApi() {
		return GroupedOpenApi.builder()
				.group("WC-TicketServiceAPI")
				.packagesToScan("com.wc.ts.controller")
				.build();
	}

}
