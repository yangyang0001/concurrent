package com.inspur.threadpool_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: YANG
 * Date: 2019/5/8-22:00
 * Description: No Description
 *
 * ExecutorService
 * Executors
 *
 */
public class ThreadPoolTest {

    public static void main(String[] args){

        //查看下线程池的用法
        ExecutorService executorService = null;

        executorService = Executors.newFixedThreadPool(10);
        executorService = Executors.newCachedThreadPool();
        executorService = Executors.newSingleThreadExecutor();
        executorService = Executors.newScheduledThreadPool(2);



    }
}
