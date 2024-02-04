package com.ngoclinh.backendspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Cho phép trên tất cả các endpoint
                        .allowedOrigins("http://localhost:3000") // Thêm origin của frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Các phương thức HTTP cho phép
                        .allowedHeaders("*") // Chấp nhận mọi header
                        .allowCredentials(true); // Cho phép gửi credentials
            }
        };
    }
}
