package com.enrollment.emailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class EnrollmentEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnrollmentEmailApplication.class, args);
    }
}
