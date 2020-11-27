package com.example.kaidun.apigwzuul.config;

import com.example.kaidun.apigwzuul.filters.JwtFilter;
import com.example.kaidun.apigwzuul.filters.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Administrator
 * @date: 2020/11/26 16:51
 * @description:
 */

@Configuration
public class ZuulConfig {

    @Bean
    public MyFilter initMyfilter(){
        return new MyFilter();
    }


    @Bean
    public JwtFilter initJwtFilter(){
        return new JwtFilter();
    }


}
