package com.example.kaidun.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BackShowProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackShowProviderApplication.class, args);
    }

}
