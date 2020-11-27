package com.example.kaidun.consumer.feign;

import org.springframework.stereotype.Service;

/**
 * @author: Administrator
 * @date: 2020/11/25 9:57
 * @description:
 */

//@Primary
@Service
public class ProviderApiImpl implements ProviderApi {
    @Override
    public String invokerProviderController(String message) {
        return null;
    }

//    @Override
//    public String postTest(String author, String providerId, user u) {
//        return null;
//    }
}
