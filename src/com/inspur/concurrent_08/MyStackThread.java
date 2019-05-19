package com.inspur.concurrent_08;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: YANG
 * Date: 2019/5/7-9:23
 * Description: No Description
 * 1.首先确定哪些操作是原子性的
 * 2.其次确定wait/notify 的 位置在什么地方
 *      a. wait 和 notify 都必须在synchronized 代码块中
 *      b. wait() 在 while中
 *
 * 分析:
 *      1.首先在对array 进行 出栈和入栈的 时候 加synchronized
 *
 */
public class MyStackThread {
    //1.首先构造容器,现在容器的容量为10
    private static int[] array = new int[10];

    //2.对容器中的元素的个数进行计数
    private AtomicInteger count = new AtomicInteger(0);

    //3.容器中元素个数的上限
    private static final int maxSize = 10;

    //4.容器中元素个数的下限
    private static final int minSize = 0;


    private final Object lock = new Object();

    //5.模拟出栈 出栈 操作
    public int get(){
        int outValue = 0;
        try {
            synchronized (lock) {
                while(count.get() == minSize){
                    lock.wait();
                }
                //a.首先获取值
                outValue = array[count.get()-1];
                //b.元素个数-1
                count.decrementAndGet();
                //c.唤醒其他线程
                lock.notifyAll();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return outValue;
    }

    //5.模拟入栈 操作
    public void put(int inValue){
        try {
            synchronized (lock) {
                while(count.get() == maxSize){
                    lock.wait();
                }

                //a.元素的个数+1
                count.incrementAndGet();
                //b.压栈操作
                array[count.get() -1] = inValue;
                //c.唤醒其他线程
                lock.notifyAll();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyStackThread stack = new MyStackThread();

        Thread[] consumers = new Thread[10];
        Thread[] producers = new Thread[10];

        for(int i=0; i<10; i++){
            consumers[i] = new Thread(() -> {
                System.out.println("消费者线程:" + Thread.currentThread().getName() + ",消费:" + stack.get());
            }, "c" + i);

            producers[i] = new Thread(() -> {
                int inValue = new Random().nextInt(10);
                stack.put(inValue);
                System.out.println("生产者线程:" + Thread.currentThread().getName() + ",生产:" + inValue);
            }, "producer" + i);
        }


        for(int i=0; i<10; i++){
            producers[i].start();
        }
        for(int i=0; i<10; i++){
            consumers[i].start();
        }
    }


}
