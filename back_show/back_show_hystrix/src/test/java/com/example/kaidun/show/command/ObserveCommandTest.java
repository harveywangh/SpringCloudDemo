package com.example.kaidun.show.command;

import org.junit.jupiter.api.Test;
import rx.Observable;
import rx.Subscriber;

/**
 * @author: Administrator
 * @date: 2020/11/20 19:05
 * @description:
 */
public class ObserveCommandTest {


    @Test
    public void observeTest() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        ObserveCommandDemo observeCommandDemo = new ObserveCommandDemo("ObserveCommandTest-observe");
        Observable<String> observe = observeCommandDemo.observe();

        //阻塞式调用
//        String result = observe.toBlocking().single();
//        long endTime = System.currentTimeMillis();
//        System.out.println("ObserveCommandTest::::  result : " + result + " , speeding = " + (endTime- beginTime));

        //非阻塞式调用
        observe.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.err.println("ObserveCommandTest-observe , onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("ObserveCommandTest-observe , onError - throwable = " + throwable);
            }

            @Override
            public void onNext(String result) {
                long endTime1 = System.currentTimeMillis();
                System.err.println("ObserveCommandTest-observe , onNext - result = " + result + ",speeding = "+ (endTime1 - beginTime));
            }
        });
        Thread.sleep(2000l);
    }
}
