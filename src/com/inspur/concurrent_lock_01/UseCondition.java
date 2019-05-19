package com.inspur.concurrent_lock_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: YANG
 * Date: 2019/5/9-20:48
 * Description: No Description
 */
public class UseCondition {

    private final ReentrantLock reentrantLock = new ReentrantLock(true);
    private Condition c1  = reentrantLock.newCondition();
    private Condition c2  = reentrantLock.newCondition();

    public void m1(){
        reentrantLock.lock();
        try {
            System.out.println("线程:" + Thread.currentThread().getName() + ",进入m1...");
            Thread.currentThread().sleep(5000);
            c1.await();
            System.out.println("线程:" + Thread.currentThread().getName() + ",退出m1...");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
              reentrantLock.unlock();
        }
    }

    public void m2(){
        reentrantLock.lock();
        try {
            System.out.println("线程:" + Thread.currentThread().getName() + ",进入m2...");
            Thread.currentThread().sleep(5000);
            c1.await();
            System.out.println("线程:" + Thread.currentThread().getName() + ",退出m2...");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
              reentrantLock.unlock();
        }
    }
    public void m3(){
        reentrantLock.lock();
        try {
            System.out.println("线程:" + Thread.currentThread().getName() + ",进入m3...");
            Thread.currentThread().sleep(5000);
            c2.await();
            System.out.println("线程:" + Thread.currentThread().getName() + ",退出m3...");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
              reentrantLock.unlock();
        }
    }
    public void m4(){
        reentrantLock.lock();
        try {
            System.out.println("线程:" + Thread.currentThread().getName() + ",进入m4...");
            Thread.currentThread().sleep(5000);
            c1.signalAll();
            System.out.println("线程:" + Thread.currentThread().getName() + ",退出m4...");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
              reentrantLock.unlock();
        }
    }
    public void m5(){
        reentrantLock.lock();
        try {
            System.out.println("线程:" + Thread.currentThread().getName() + ",进入m5...");
            Thread.currentThread().sleep(5000);
            c2.signal();
            System.out.println("线程:" + Thread.currentThread().getName() + ",退出m5...");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
              reentrantLock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final UseCondition useCondition = new UseCondition();
        ExecutorService executorService = Executors.newCachedThreadPool();

        Thread thread1 = new Thread(() -> {
            useCondition.m1();      //c1.await();
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            useCondition.m2();      //c1.await();
        }, "thread2");

        Thread thread3 = new Thread(() -> {
            useCondition.m3();      //c2.await();
        }, "thread3");

        Thread thread4 = new Thread(() -> {
            useCondition.m4();      //c1.signalAll();
        }, "thread4");

        Thread thread5 = new Thread(() -> {
            useCondition.m5();      //c2.signal();
        }, "thread5");

//        executorService.execute(thread1);
//        executorService.execute(thread2);
//        executorService.execute(thread3);
        thread1.start();
        thread2.start();
        thread3.start();

        Thread.currentThread().sleep(5000);

//        executorService.execute(thread4);
//        executorService.execute(thread5);
        executorService.shutdown();
    }


}
