package com.example.kaidun.cinema.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.kaidun.cinema.controller.vo.DescCinemasRespVo;
import com.example.kaidun.cinema.controller.vo.SaveCinemasReqVo;
import com.example.kaidun.cinema.service.CinemaService;
import com.example.kaidun.utils.common.vo.BasePageVo;
import com.example.kaidun.utils.common.vo.BaseResponseVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import com.google.common.collect.Maps;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: Administrator
 * @date: 2020/11/18 17:46
 * @description:
 */
@RestController
@RequestMapping(value = "/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;


    /**
     * fallback 是业务处理的保底方案，尽可能的保证这个保底方案能成功
     * @param basePageVo
     * @return
     * @throws CommonServiceException
     */
    public BaseResponseVo fallbackMethod(@RequestBody BasePageVo basePageVo) throws CommonServiceException {

        /*String result = "";
        Map<String, Object> map = Maps.newHashMap();
        map.put("message", "请求处理降级返回");
        map.put("code", 500);*/

        //descCinemas -》 获取影院列表 - 》 在Redios中查询【Redios挂了或者数据没了】 - 获取超时或者失败
        //在fallBack捕获超时或者数据内容与数据库不一致
        //fallBack在数据库查询真实影院信息





        //返回一定是成功 或者 业务处理失败
        return BaseResponseVo.success();
    }

    /*@HystrixCommand 注解会将 descCinemas方法为run()方法执行*/
    @HystrixCommand(fallbackMethod = "fallbackMethod",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "1000"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "8"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1500")
            }, ignoreExceptions = CommonServiceException.class)//那些异常类不需要降级
    @GetMapping(value = "/")
    public BaseResponseVo descCinemas(@RequestBody BasePageVo basePageVo) throws CommonServiceException {


        if (basePageVo.getNowPage() > 1000) {
            throw new CommonServiceException(400, "太大了"); //异常特殊处理
//                Thread.sleep(2000); //超时降级
        }


        basePageVo.checkParam();
        //查询影院信息
        IPage<DescCinemasRespVo> iPage = cinemaService.descCinemas(basePageVo);


        return BaseResponseVo.success(descPageResult(iPage, "cinemas"));
    }

    @PostMapping(value = "cinema:add")
    public BaseResponseVo saveCinemas(@RequestBody SaveCinemasReqVo saveCinemasReqVo) throws CommonServiceException {
        saveCinemasReqVo.checkParam();
        return BaseResponseVo.success();
    }


    public Map<String, Object> descPageResult(IPage iPage, String title) {
        Map<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("totalSize", iPage.getTotal());//总数据
        resultMap.put("totalPages", iPage.getPages());//总页数
        resultMap.put("pageSize", iPage.getSize());//当前页条数
        resultMap.put("nowPage", iPage.getCurrent());//当前页数
        resultMap.put(title, iPage.getRecords());
        return resultMap;
    }

}
