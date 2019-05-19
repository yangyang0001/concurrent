package com.inspur.concurrent_back;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: YANG
 * Date: 2019/5/10-11:12
 * Description: No Description
 * 复习：CountDownLatch
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newCachedThreadPool();

        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("线程:" + Thread.currentThread().getName() + "线程进入...");
                countDownLatch.await();
                System.out.println("线程:" + Thread.currentThread().getName() + "线程退出...");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("线程:" + Thread.currentThread().getName() + "线程进入... ");
                countDownLatch.await();
                System.out.println("线程:" + Thread.currentThread().getName() + "线程退出... ");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }, "thread2");


        executorService.execute(thread1);
        executorService.execute(thread2);

        Thread.currentThread().sleep(1000);

        long count = countDownLatch.getCount();
        for(int i = 0; i < count; i++){
            countDownLatch.countDown();
        }

        executorService.shutdown();
    }
}
