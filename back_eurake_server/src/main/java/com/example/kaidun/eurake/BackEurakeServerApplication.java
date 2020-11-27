package com.example.kaidun.eurake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BackEurakeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEurakeServerApplication.class, args);
    }

}
