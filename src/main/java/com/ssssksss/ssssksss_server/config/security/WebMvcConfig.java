package com.ssssksss.ssssksss_server.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowCredentials(true)
                .allowedOrigins("http://blog.ssssksss.xyz");
//                .allowedHeaders("*")
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
//                .maxAge(-1)
//                .allowCredentials(false);
    }
}