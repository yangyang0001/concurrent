package com.inspur.concurrent_back;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * User: YANG
 * Date: 2019/5/10-12:09
 * Description: No Description
 * 信号量,对多线程访问同一个方法进行限流
 */
public class SemaphoreTest {

    final Semaphore semaphore = new Semaphore(5);

    public void method(){
        try {
            semaphore.acquire();
            System.out.println("线程:" + Thread.currentThread().getName() + "运行..");
            Thread.currentThread().sleep(2000);
            semaphore.release();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        final SemaphoreTest test = new SemaphoreTest();

        Thread[] threads = new Thread[20];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(() -> {
                test.method();
            }, "thread" + (i+1));
        }

        for(int i = 0; i < threads.length; i++){
            executorService.execute(threads[i]);
        }

        executorService.shutdown();
    }


}
