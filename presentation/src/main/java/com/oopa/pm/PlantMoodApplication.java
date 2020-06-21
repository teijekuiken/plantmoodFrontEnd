package com.oopa.pm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.oopa")
@EnableJpaRepositories("com.oopa.dataAccess.repositories")
@EnableJpaAuditing
@EntityScan("com.oopa.dataAccess.model")
public class PlantMoodApplication {
    public static void main(String[] args){
        SpringApplication.run(PlantMoodApplication.class, args);
    }
}
