package com.example.kaidun.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Administrator
 * @date: 2020/11/17 15:35
 * @description:
 */
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    //让RestTemplate 具有负载均衡调整的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    //Ribbon默认参数类文件  DefaultClientConfigImpl
    //Ribbon的key定义  CommonClientConfigKey
    //参数定义格式：<client>.ribbon.<key>=<value>
    /**
     * 负载均衡规则
     * @return
     */
    @Bean
    public IRule iRule(){
        return new RoundRobinRule();
//        return new MyRules();
    }

    //探测服务存活状态
//    @Bean
//    public IPing iPing(){
//        return new PingUrl(false,"/abc");//对http client对服务进行ping操作
//     使用最多   return new NIWSDiscoveryPing();//不执行ping操作，根据Eurake Server的反馈判断存活
//    DummyPing //“人性本善”  默认返回TRUE
    //NoOpPing   //不执行操作，返回true
//    }




}
