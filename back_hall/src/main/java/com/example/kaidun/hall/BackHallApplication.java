package com.example.kaidun.hall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.example.kaidun.hall.dao"})
@ComponentScan(basePackages = {"com.example.kaidun"})
public class BackHallApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackHallApplication.class, args);
    }

}
