package com.inspur.concurrent_01;

/**
 * 这里加上synchronized 的时候就会产生多个线程进行 锁竞争的问题!
 * 问题:这里的锁是什么锁呢? 这个锁锁住的是谁呢?
 */
public class MyThread extends Thread {

    private int count = 5;

    //这里是通过synchronized 来 加锁的
    @Override
    public synchronized void run() {
        count --;
        System.out.println("ThreadName:------:" + Thread.currentThread().getName() + ",  count----:" + count);
    }

    public static void main(String[] args){
        MyThread myThread = new MyThread();

        Thread t1= new Thread(myThread, "t1");
        Thread t2= new Thread(myThread, "t2");
        Thread t3= new Thread(myThread, "t3");
        Thread t4= new Thread(myThread, "t4");
        Thread t5= new Thread(myThread, "t5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
