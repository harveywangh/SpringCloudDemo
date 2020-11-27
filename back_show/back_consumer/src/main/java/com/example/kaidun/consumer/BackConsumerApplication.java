package com.example.kaidun.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class BackConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackConsumerApplication.class, args);
    }

}
