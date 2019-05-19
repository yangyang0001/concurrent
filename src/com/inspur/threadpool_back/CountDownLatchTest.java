package com.inspur.threadpool_back;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: YANG
 * Date: 2019/5/13-20:37
 * Description: No Description
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread[] threads = new Thread[10];
        ExecutorService executorService = Executors.newFixedThreadPool(threads.length);

        AtomicInteger count= new AtomicInteger(0);

        for(int i = 0; i < 10; i++){
            threads[i] = new Thread(() -> {
                try {
                    countDownLatch.await();
                    System.out.println("线程:" + Thread.currentThread().getName() + "开始执行...");
                    for(int j = 0; j < 10; j++){
                        count.incrementAndGet();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }, "thread" + (i+1));
        }

        for(int i = 0; i < 10; i++){
            executorService.execute(threads[i]);
        }

        countDownLatch.countDown();

        Thread.sleep(1000);
        executorService.shutdown();
        System.out.println(count.get());

    }





}
