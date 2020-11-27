package com.example.kaidun.consumer.service.impl;

import com.example.kaidun.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Administrator
 * @date: 2020/11/17 15:30
 * @description:
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private RestTemplate restTemplate;


    //原始服务调用
//    @Override
//    public String sayHellow(String message) {
//        //调用provider test
//
//        String hostname = "localhost";
//        int port = 7101;
//        String uri = "/provider/sayhellow?message=" + message;
//
//        String url = "http://" + hostname + ":" + port + uri;
//        String result = restTemplate.getForObject(url, String.class);
//
//        return result;
//    }



    //eurake根据name调用   GET Register
//    @Autowired
//    private LoadBalancerClient eurakeClient;
    @Override
    public String sayHellow(String message) {

        //GET Register
//        ServiceInstance choose = eurakeClient.choose("provider-service");
//        choose.getServiceId();
//        String hostname = choose.getHost();
//        int port = choose.getPort();
        String uri = "/provider/sayhellow?message=" + message;




        String url = "http://provider-service" + uri;
        String result = restTemplate.getForObject(url, String.class);

        return result;
    }
}
