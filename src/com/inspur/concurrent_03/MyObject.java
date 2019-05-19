package com.inspur.concurrent_03;

/**
 * User: YANG
 * Date: 2019/5/6-11:39
 * Description: No Description
 */
public class MyObject {

    public synchronized void method1 (){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.currentThread().sleep(4000);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }

    public synchronized void method2 (){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args){

        final MyObject object = new MyObject();

        Thread t1 = new Thread(()->{
            //这种顺序验证了 synchronized 是 可重入锁, 当然可重入锁对往往是对一个线程来说的!
            //因为method1()中 有Thread.currentThread.sleep()方法,所以采用这种方式!
            object.method2();
            object.method1();
        }, "t1");

        Thread t2 = new Thread(()->{
            object.method2();
        }, "t2");

        t1.start();
        t2.start();

    }
}
