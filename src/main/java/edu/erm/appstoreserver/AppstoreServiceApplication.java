package edu.erm.appstoreserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class AppstoreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppstoreServiceApplication.class, args);
    }

    // Erfan: Enable Cross-Origin Request Sharing
    // Erfan:  It not suitable for public API. must be more closer.
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
