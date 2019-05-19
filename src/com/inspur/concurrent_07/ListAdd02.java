package com.inspur.concurrent_07;

import java.util.ArrayList;
import java.util.List;

/**
 * User: YANG
 * Date: 2019/5/6-17:57
 * Description: No Description
 * 验证 notify() 不释放锁, wait() 释放锁, 一定是 wait() 方法 所在的线程先执行!
 */
public class ListAdd02 {

    public static volatile List<String> list = new ArrayList<String>();

    public void add(){
        this.list.add("concurrent");
    }

    public int size(){
        return this.list.size();
    }



    public static void main(String[] args) throws InterruptedException {

        final ListAdd02 listAdd02 = new ListAdd02();

        final Object lock = new Object();

        Thread thread1 = new Thread(()-> {
            synchronized (lock) {
                try {
                    for(int i=0; i<10; i++){
                        listAdd02.add();
                        System.out.println("当前线程:" + Thread.currentThread().getName() + "添加了一个元素...");
                        Thread.currentThread().sleep(500);
                        if(listAdd02.size() == 5){
                            lock.notify();  //不释放锁
                            System.out.println("发出通知...");
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }, "t1");

        Thread thread2 = new Thread(()-> {
            synchronized (lock) {
                if(listAdd02.size() != 5){
                    try {
                        lock.wait();       //释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("list.size == 5 当前线程:" + Thread.currentThread().getName() + "抛出异常结束");
                throw new RuntimeException();
            }
        }, "t2");
        //这里一定要thread2.start() 先执行!
        thread2.start();
        Thread.currentThread().sleep(1000);
        thread1.start();

    }
}
