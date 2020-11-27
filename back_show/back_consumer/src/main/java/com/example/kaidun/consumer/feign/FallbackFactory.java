package com.example.kaidun.consumer.feign;

import org.springframework.stereotype.Component;

/**
 * @author: Administrator
 * @date: 2020/11/25 13:58
 * @description:
 */
@Component
public class FallbackFactory implements feign.hystrix.FallbackFactory {


    @Override
    public ProviderApi create(Throwable throwable) {
        return new ProviderApi() {
            @Override
            public String invokerProviderController(String message) {
                return "FallbackFactory invokerProviderController message = " + message;
            }
        };
    }
}
