package com.example.kaidun.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Administrator
 * @date: 2020/11/17 15:23
 * @description:
 */

@Slf4j
@RestController
public class ProviderController {

    @Value("${server.port}")
    private int port;


    @RequestMapping(value = "/provider/sayhellow",method = RequestMethod.GET)
    private String providerSayHellow(@RequestParam("message") String message) {
        log.error("provider  sayhellow :: port = {}, messqge = {}", port, message);
        return "provider sayHellow port = " + port + ", messqge = " + message;
    }


    @PostMapping(value = "/provider/{providerId}/postTest")
    private String postTest(
            @RequestHeader("author") String author,
            @PathVariable("providerId") String providerId,
            @RequestBody String json) {
        log.error("provider  sayhellow :: port = {}, messqge = {},providerId={},author={}", port, json,providerId,author);
        return "provider sayHellow port = " + port + ", messqge = " + json;
    }

}
