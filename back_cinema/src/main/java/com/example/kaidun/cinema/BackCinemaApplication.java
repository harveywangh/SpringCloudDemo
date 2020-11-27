package com.example.kaidun.cinema;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.example.kaidun"})
@MapperScan(basePackages = {"com.example.kaidun.cinema.dao"})
public class BackCinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackCinemaApplication.class, args);
    }

}
