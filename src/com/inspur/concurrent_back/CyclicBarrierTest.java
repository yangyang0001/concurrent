package com.inspur.concurrent_back;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: YANG
 * Date: 2019/5/10-11:32
 * Description: No Description
 */
public class CyclicBarrierTest {

    public static void main(String[] args){

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Thread[] threads = new Thread[3];

        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(() -> {
                try {
                    System.out.println("线程:" + Thread.currentThread().getName() + "进入..");
                    cyclicBarrier.await();
                    System.out.println("线程:" + Thread.currentThread().getName() + "退出..");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        }

        for(int i = 0; i < threads.length; i++){
            executorService.execute(threads[i]);
        }

        executorService.shutdown();
    }

}
