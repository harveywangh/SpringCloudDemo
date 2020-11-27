package com.example.kaidun.consumer.controller;

import com.example.kaidun.consumer.feign.ProviderApi;
import com.example.kaidun.consumer.feign.user;
import com.example.kaidun.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: Administrator
 * @date: 2020/11/17 15:31
 * @description:
 */

@RestController
@Slf4j
public class ConsumerController {


    @Value("${server.port}")
    private String port;

    @Resource
    private ConsumerService consumerService;

    @Resource
    private ProviderApi providerApi;


    @RequestMapping(value = "/sayhellow/post")
    public String sayHellowFeign(String autor, user u, String providerId) {

//        System.out.println("Feign message = " + message);
        System.out.println("Feign autor = " + autor);
        System.out.println("Feign user = " + u);
        System.out.println("Feign providerId = " + providerId);

//        return "comsumer sayhellow is port = " + port + "message = " + message;
//        user u = new user();
//        u.setUserName("harvey");
//        u.setPassword("123123");
//        return providerApi.postTest(autor, providerId, u);
        return "";
    }


    @RequestMapping(value = "/sayhellow/feign")
    public String sayHellowFeign(String message) {

        System.out.println("Feign message = " + message);


//        return "comsumer sayhellow is port = " + port + "message = " + message;
        return providerApi.invokerProviderController(message);
    }


    @RequestMapping(value = "/sayhellow")
    public String sayHellow(String message) {


//        return "comsumer sayhellow is port = " + port + "message = " + message;
        return consumerService.sayHellow(message);
    }

}
