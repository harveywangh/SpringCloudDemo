package com.example.kaidun.show.command;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * @author: Administrator
 * @date: 2020/11/20 18:57
 * @description:
 */
public class ObserveCommandDemo extends HystrixObservableCommand<String> {
    private String name;

    protected ObserveCommandDemo(String name) {
        super(Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("ObserveCommandHelloWord")));
        this.name = name;
    }

    @Override
    protected Observable construct() {
        System.err.println("current Thread:" + Thread.currentThread().getName());


        return Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                //TODO 业务处理--》批量处理

                //每一次onNext可以一次业务处理
                subscriber.onNext("action1 , name = " + name);
                subscriber.onNext("action2 , name = " + name);
                subscriber.onNext("action3 , name = " + name);
                subscriber.onNext("action4 , name = " + name);


                subscriber.onCompleted();//业务处理结束
            }
        }).subscribeOn(Schedulers.io());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
