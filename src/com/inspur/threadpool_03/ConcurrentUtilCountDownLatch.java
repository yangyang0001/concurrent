package com.inspur.threadpool_03;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: YANG
 * Date: 2019/5/9-15:24
 * Description: No Description
 * CountDownLatch 的使用  await() 和 countDown() 方法!有点类似发令枪的意思
 */
public class ConcurrentUtilCountDownLatch {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger count = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Thread[] threads = new Thread[3];

        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    System.out.println("线程:" + Thread.currentThread().getName() + "主备开始...");
                    Thread.currentThread().sleep(1000);
                    countDownLatch.await();
                    System.out.println("线程:" + Thread.currentThread().getName() + "主备完毕...");
                    for(int j = 0; j < 100; j++){
                        count.incrementAndGet();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }, "t" + (i+1));
        }

        for(int i = 0; i < 3; i++){
            executorService.execute(threads[i]);
            countDownLatch.countDown();
        }

        Thread.sleep(5000);
        System.out.println(count.get());

        executorService.shutdown();
    }
}
