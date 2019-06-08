package edu.eam.appstoreserver;

import edu.eam.appstoreserver.legacy.AppProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(AppProductRepository repository) {
        return  args -> {
        };
    }

}