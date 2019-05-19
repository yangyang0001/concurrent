package com.inspur.concurrent_08;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: YANG
 * Date: 2019/5/6-19:17
 * Description: No Description
 * 线程问题:
 *      1.首先确定什么什么样的操作是原子性操作(在什么地方加lock)
 *      2.while 循环中填写wait() 这是推荐
 */
public class MyQueueThread {

    //1.设定一个容器
    private static volatile int[] array = new int[10];

    //2.array 长度计数器
    private AtomicInteger count = new AtomicInteger(0);

    //3.定义容器中元素的最大个数
    private int maxSize = 10;

    //4.定义容器中元素的最小个数
    private int minSize = 0;


    private final Object lock = new Object();

    public void put(int value){
        synchronized (lock) {
            try {
                while(count.get() == maxSize){
                    lock.wait();
                }

                count.incrementAndGet();
                System.out.println("当前生产者线程:" + Thread.currentThread().getName() + ",生产" + value);
                array[count.get()-1] = value;
                lock.notifyAll();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }


    }

    public void get(){
        synchronized (lock) {
            try {
                while(count.get() == minSize){
                    lock.wait();
                }

                int result = array[count.get()-1];
                System.out.println("当前消费者线程:" + Thread.currentThread().getName() + ",count值:" + count.get() + ",消费" + result);
                count.decrementAndGet();
                lock.notifyAll();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final MyQueueThread lock = new MyQueueThread();

        Thread[] consumers = new Thread[3];
        Thread[] producers = new Thread[3];

        for(int i=0; i < consumers.length; i++){
            producers[i] = new Thread(() -> {
                for(int j=0; j<10; j++){
                    lock.put(new Random().nextInt(10));
                }
            }, "producer" + i);

            consumers[i] = new Thread(() -> {
                for(int j=0; j<10; j++){
                    lock.get();
                }
            }, "c" + i);
        }

        for(int i=0; i < producers.length; i++){
            producers[i].start();
        }

        Thread.currentThread().sleep(5000);

        for(int i=0; i < consumers.length; i++){
            consumers[i].start();
        }
    }

}
