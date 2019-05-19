package com.inspur.concurrent_05;

/**
 * User: YANG
 * Date: 2019/5/6-14:48
 * Description: No Description
 */
public class ObjectLock {

    //当前对象锁
    public void method1(){
        synchronized (this) {
            System.out.println("method1 invoked");
        }
    }
    //Class 类锁
    public void method2(){
        synchronized (ObjectLock.class) {
            System.out.println("method2 invoked");
        }
    }

    //任何实例化的锁
    private Object object = new Object();

    public void method3(){
        synchronized (object) {
            System.out.println("method3 invoked");
        }
    }


    public static void main(String[] args){
        final ObjectLock objectLock = new ObjectLock();

        Thread thread1 = new Thread(() -> {
            objectLock.method1();
        }, "t1");

        Thread thread2 = new Thread(() -> {
            objectLock.method2();
        }, "t2");

        Thread thread3 = new Thread(() -> {
            objectLock.method3();
        }, "t3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
