package com.example.scheduler2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Scheduler2Application {

    public static void main(String[] args) {
        SpringApplication.run(Scheduler2Application.class, args);
    }

}
