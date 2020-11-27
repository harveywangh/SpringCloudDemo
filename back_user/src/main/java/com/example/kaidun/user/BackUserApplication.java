package com.example.kaidun.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
@ComponentScan(basePackages = {"com.example.kaidun"})//扫描其他模块内容
@MapperScan(basePackages = {"com.example.kaidun.user.dao.mapper"})
public class BackUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackUserApplication.class, args);
    }

}
