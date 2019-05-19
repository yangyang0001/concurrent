package com.inspur.concurrent_12;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * User: YANG
 * Date: 2019/5/7-19:10
 * Description: No Description
 * 无界 非阻塞 队列, FIFO
 * add() offer() 都是往队列尾部添加元素
 * poll() peek() 是弹出队列(poll(): 队列头部的元素从队列中删除,并返回给调用者, peek():取出队列中头部的元素返回,但是不从队列中删除 )
 *
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();

        Thread thread1 = new Thread(() -> {
            for(int i=0; i<10; i++){
                concurrentLinkedQueue.add("aaa" + i);
                System.out.println("当前线程:" + Thread.currentThread().getName() + ",concurrentLinkedQueue.size:" + concurrentLinkedQueue.size());
            }

        }, "t1");

        Thread thread2 = new Thread(() -> {
//            for(int i=0; i<10; i++){
//                concurrentLinkedQueue.poll();
                concurrentLinkedQueue.peek();
                System.out.println("当前线程:" + Thread.currentThread().getName() + ",concurrentLinkedQueue.size:" + concurrentLinkedQueue.size());
//            }
        }, "t2");

        thread1.start();
        Thread.currentThread().sleep(2000);
        thread2.start();
        Thread.currentThread().sleep(2000);

        concurrentLinkedQueue.stream().forEach(System.out::println);
    }

}
