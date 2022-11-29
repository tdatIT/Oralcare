package com.oralcare.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OralcareApplication {

    public static void main(String[] args) {
        SpringApplication.run(OralcareApplication.class, args);
    }

}
