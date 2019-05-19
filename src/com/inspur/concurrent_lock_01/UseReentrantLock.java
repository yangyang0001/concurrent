package com.inspur.concurrent_lock_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: YANG
 * Date: 2019/5/9-20:20
 * Description: No Description
 * 和Synchronized 的效果一样,都是可重入的排他锁
 */
public class UseReentrantLock {

    private final ReentrantLock reentrantLock = new ReentrantLock();

    public void method1(){
        reentrantLock.lock();
        try {
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method1...");
            Thread.currentThread().sleep(5000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method1...");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void method2(){
        reentrantLock.lock();
        try {
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method2...");
            Thread.currentThread().sleep(5000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method2...");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }


    public static void main(String[] args){

        UseReentrantLock useReentrantLock = new UseReentrantLock();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread[] threads = new Thread[2];

        threads[0] = new Thread(() -> {
            useReentrantLock.method1();
        }, "thread0");

        threads[1] = new Thread(() -> {
            useReentrantLock.method2();
        }, "thread1");

        executorService.execute(threads[0]);
        System.out.println("-----------------------------------------------------------");
        executorService.execute(threads[1]);

        executorService.shutdown();
    }


}
