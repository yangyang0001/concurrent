package com.inspur.threadpool_03;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: YANG
 * Date: 2019/5/9-16:00
 * Description: No Description
 *
 *
 * CyclicBarrier 是另外一种更具象的CountDownLatch的实现,不用去操作countDown(); 只用await()去等着就OK了
 *
 */
public class ConcurrentUtilCyclicBarrier {

    public static void main(String[] args){

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Thread[] threads = new Thread[3];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(() -> {
                try {
                    System.out.println("线程:" + Thread.currentThread().getName() + "主备开始...");
                    cyclicBarrier.await();
                    System.out.println("线程:" + Thread.currentThread().getName() + "主备完毕...");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }, "t" + (i+1));
        }

        for(int i = 0; i < threads.length; i++){
            executorService.execute(threads[i]);
        }

        executorService.shutdown();
    }
}
