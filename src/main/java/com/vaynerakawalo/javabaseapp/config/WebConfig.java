package com.vaynerakawalo.javabaseapp.config;

import com.vaynerakawalo.springobservability.ObservabilityAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@ImportAutoConfiguration(classes = ObservabilityAutoConfiguration.class)
public class WebConfig {
}
