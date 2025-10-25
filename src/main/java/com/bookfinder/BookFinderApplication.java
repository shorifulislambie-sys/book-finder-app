package com.bookfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.bookfinder.repository")
@EntityScan("com.bookfinder.model")
public class BookFinderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookFinderApplication.class, args);
    }
}