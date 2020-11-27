package com.example.kaidun.consumer.feign;

import org.springframework.stereotype.Component;

/**
 * @author: Administrator
 * @date: 2020/11/25 13:26
 * @description: 降级实现
 */
@Component
public class ProviderFallBackApiImpl implements ProviderApi {


    @Override
    public String invokerProviderController(String message) {
        return "invokerProviderController Fallback message = " + message;
    }
}
