package com.inspur.concurrent_lock_01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * User: YANG
 * Date: 2019/5/9-23:14
 * Description: No Description
 *
 * ReentrantReadWriteLock 适合读多写少的情况
 *
 * 类似与Serializable, 原则: 读读共享, 读写互斥, 写写互斥
 *
 */
public class UseReentrantReadWriteLock {

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    private Condition readCondition = readLock.newCondition();
    private Condition writeCondition = writeLock.newCondition();

    public void read(){
        readLock.lock();
        try {
            System.out.println("线程:" + Thread.currentThread().getName() + ",进入read()...");
            Thread.currentThread().sleep(3000);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void write(){
        writeLock.lock();
        try {
            System.out.println("线程:" + Thread.currentThread().getName() + ",进入write()...");
            Thread.currentThread().sleep(3000);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }


    public static void main(String[] args){
        final UseReentrantReadWriteLock useReentrantReadWriteLock = new UseReentrantReadWriteLock();

        Thread thread1 = new Thread(() -> {useReentrantReadWriteLock.read();});
        Thread thread2 = new Thread(() -> {useReentrantReadWriteLock.read();});
        Thread thread3 = new Thread(() -> {useReentrantReadWriteLock.write();});
        Thread thread4 = new Thread(() -> {useReentrantReadWriteLock.write();});

        //读读共享
//        thread1.start();    //R
//        thread2.start();    //R

        //读写互斥
//        thread1.start();    //R
//        thread3.start();    //W

        //写写互斥
//        thread3.start();    //W
//        thread4.start();    //W
    }


}
