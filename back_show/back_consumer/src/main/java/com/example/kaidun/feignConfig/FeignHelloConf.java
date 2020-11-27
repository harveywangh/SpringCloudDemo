package com.example.kaidun.feignConfig;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Administrator
 * @date: 2020/11/25 10:17
 * @description:  针对单个接口提供不同的配置  千人千面
 * 注意事项：1、自定义配置要在spring作用于范围之外
 *      启发：    2、Configuration用法
 */
@Configuration
public class FeignHelloConf {

    @Bean
    public Contract contract(){
        return new feign.Contract.Default();
    }

}
