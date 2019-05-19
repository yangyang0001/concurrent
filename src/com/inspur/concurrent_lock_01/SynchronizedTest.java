package com.inspur.concurrent_lock_01;

/**
 * User: YANG
 * Date: 2019/5/9-21:40
 * Description: No Description
 */
public class SynchronizedTest {

    public synchronized void method1(){
        try {
            System.out.println("线程:" + Thread.currentThread().getName() + ",进入method1...");
            method2();
            System.out.println("线程:" + Thread.currentThread().getName() + ",退出method1...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public synchronized static void method2(){
        try {
            System.out.println("线程:" + Thread.currentThread().getName() + ",进入method2...");
            Thread.currentThread().sleep(10000);
            System.out.println("线程:" + Thread.currentThread().getName() + ",退出method2...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args){
        final SynchronizedTest test = new SynchronizedTest();

        Thread thread1 = new Thread(() -> {
            test.method1();
        }, "thread1");

//        Thread thread2 = new Thread(() -> {
//            test.method2();
//        }, "thread2");

        thread1.start();
//        thread2.start();
    }

}
