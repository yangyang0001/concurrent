package com.inspur.threadpool_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * User: YANG
 * Date: 2019/5/9-18:20
 * Description: No Description
 * 信号量的使用
 *      运用信号量,对运行进行限流
 */
public class SemaphoreTest {

    public static void main(String[] args){
        //创建信号量, 这里称之为并行信号量更好!
        Semaphore semaphore = new Semaphore(5);

        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread[] threads = new Thread[20];

        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("线程:" + Thread.currentThread().getName() + ",运行5s....");
                    Thread.currentThread().sleep(5000);
                    semaphore.release();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }, "线程" + (i+1));
        }

        for(int i = 0; i < threads.length; i++){
            executorService.execute(threads[i]);
        }

        executorService.shutdown();
    }



}
