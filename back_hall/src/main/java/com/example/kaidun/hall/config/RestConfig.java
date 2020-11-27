package com.example.kaidun.hall.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Administrator
 * @date: 2020/11/19 17:38
 * @description:
 */
@Configuration
public class RestConfig {


    @Bean
    @LoadBalanced //给RestTemplate负载权限
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //定义负载规则
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }

}
