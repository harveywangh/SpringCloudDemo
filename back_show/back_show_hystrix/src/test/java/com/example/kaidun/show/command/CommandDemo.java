package com.example.kaidun.show.command;

import com.netflix.hystrix.*;

/**
 * @author: Administrator
 * @date: 2020/11/20 17:49
 * @description:
 */

//笔记  差异
//Command会以线程隔离的形式执行run方法
//ObserveCommand使用当前线程进行调用


public class CommandDemo extends HystrixCommand {

    private String name;

    //默认会报错  需要重写
    protected CommandDemo(String name) {
        super(Setter.
                        withGroupKey(HystrixCommandGroupKey.Factory.asKey("commandHelloWord"))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("commandKey"))
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.defaultSetter().withRequestCacheEnabled(false)//关闭请求缓存
//                                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)//线程隔离模式
                                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)//信号量隔离模式
                                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(2) //信号量隔离最大请求数
//                                .withFallbackIsolationSemaphoreMaxConcurrentRequests(2) //失误时最大请求数
                                     //   .withCircuitBreakerForceOpen(true)//熔断强制开启
                                .withCircuitBreakerRequestVolumeThreshold(2)//单位时间内请求的阈值
                                .withCircuitBreakerErrorThresholdPercentage(50) //当满足请求阈值时，超过50%错误 开启熔断
                        ).andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("MyThreadPool"))//指定ThreadPoolKey名称
                        .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.defaultSetter()
                                .withCoreSize(2)//配置线程池大小，默认是10
                                //线程池中线程的最大数量，默认值10    是否开启最大线程数
                                .withMaximumSize(3).withAllowMaximumSizeToDivergeFromCoreSize(true)
                                .withMaxQueueSize(2) //等待队列

                        )
        );
        this.name = name;
    }

    //单次请求调用业务方法
    @Override
    protected Object run() throws Exception {
        String result = "commandHelloWord name = " + name;

//        Thread.sleep(800l);
        if (name.startsWith("error")) {
            int i = 6 / 0;
        }

        System.err.println(result + " , currentThread = " + Thread.currentThread().getName());
        return result;
    }


    @Override
    protected String getCacheKey() {
        return String.valueOf(name);//相同的名字  run 方法的name   也可以同一个对象  同一个xxx
    }

    @Override
    protected Object getFallback() {
        String result = "Fallback name = " + name;

        System.err.println(result + " , currentThread = " + Thread.currentThread().getName());
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
