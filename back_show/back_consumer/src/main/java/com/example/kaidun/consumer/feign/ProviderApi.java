package com.example.kaidun.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Administrator
 * @date: 2020/11/24 18:50
 * @description:
 */
/*
 * primary   优先级  默认true
 * */

@FeignClient(
//        url = "http://localhost:7101",
//        primary = true,
        path = "/provider",
        name = "provider-service",
//        fallback = ProviderFallBackApiImpl.class
        fallbackFactory = FallbackFactory.class
//        configuration = FeignHelloConf.class
)
public interface ProviderApi {

    @RequestMapping(value = "/sayhellow", method = RequestMethod.GET)
    String invokerProviderController(@RequestParam("message") String message);

//    @RequestLine("GET /sayhellow?message={message}")
//    String invokerProviderController(@Param("message") String message);


//    @PostMapping(value = "/{providerId}/postTest")
//    String postTest(
//            @RequestHeader("author") String author,
//            @PathVariable("providerId") String providerId,
//            @RequestBody user u);


}
