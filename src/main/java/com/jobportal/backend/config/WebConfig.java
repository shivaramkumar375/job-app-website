package com.jobportal.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Allow requests from your Vercel app's domain
                registry.addMapping("/api/**") // Or "/**" for all endpoints
                        .allowedOrigins("https://jobapp-frontend.vercel.app/")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
