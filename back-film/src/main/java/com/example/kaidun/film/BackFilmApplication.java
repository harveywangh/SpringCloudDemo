package com.example.kaidun.film;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.example.kaidun.film.dao"})
@ComponentScan(basePackages = {"com.example.kaidun"})
public class BackFilmApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackFilmApplication.class, args);
    }

}
