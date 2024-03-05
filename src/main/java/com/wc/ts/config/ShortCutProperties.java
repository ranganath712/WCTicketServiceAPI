package com.wc.ts.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "tburls")
public class ShortCutProperties {

	public Map<String, String> urls = new HashMap<>();
}
