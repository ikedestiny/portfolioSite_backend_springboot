package dev.destiny.portfoliositebackendspringboot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for all endpoints
        registry.addMapping("/**")
                .allowedOrigins("/*")  // or "*" to allow all origins
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Specify allowed HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true)  // Allow credentials (cookies, etc.)
                .maxAge(3600);  // Cache preflight response for 1 hour
    }
}
