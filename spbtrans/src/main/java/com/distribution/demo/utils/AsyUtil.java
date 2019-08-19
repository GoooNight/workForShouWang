package com.distribution.demo.utils;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description 定时器加异步
 * @author:awei
 * @date:2019/8/19
 * @ver:1.0
 **/
@Component
@EnableScheduling
public class AsyUtil {


    @Scheduled(cron = "0/1 * * * * ?")
    @Async
    public void show() throws InterruptedException {
        System.out.println("你好啊");
        Thread.sleep(5000);
        System.out.println("我结束了");
    }


}
