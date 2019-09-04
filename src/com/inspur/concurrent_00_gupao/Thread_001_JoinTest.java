package com.inspur.concurrent_00_gupao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-08-22 18:17
 * 1.如何保证线程的执行顺序? join()方法可以!  同样适用 ExecutorService中的 线程池照样可以完成以上的功能
 */
public class Thread_001_JoinTest {

    public static Thread thread1 = new Thread(() -> {
        System.out.println("thread1");
    });

    public static Thread thread2 = new Thread(() -> {
        System.out.println("thread2");
    });

    public static Thread thread3 = new Thread(() -> {
        System.out.println("thread3");
    });


    public static void main(String[] args) throws InterruptedException {

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);

        executorService.shutdown();
    }

}
