package com.hl.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MainDingdingApplication {

    public static void main(String[] args)  {
        SpringApplication.run(MainDingdingApplication.class, args);
    }
}
