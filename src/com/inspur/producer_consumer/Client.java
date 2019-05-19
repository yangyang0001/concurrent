package com.inspur.producer_consumer;

import java.util.Random;

/**
 * User: YANG
 * Date: 2019/5/9-8:51
 * Description: No Description
 */
public class Client {

    public static void main(String[] args){

        StackData stackData = new StackData();

        Thread[] producers = new Thread[10];
        Thread[] consumers = new Thread[10];

        Random random = new Random();

        for(int i = 0 ; i < 10; i++){
            //生产者线程组 初始化
            producers[i] = new Thread(() -> {
                stackData.put(random.nextInt(100) + 1);
            }, "p" + i);
            //消费者线程组 初始化
            consumers[i] = new Thread(() -> {
                int result = stackData.get();
                System.out.println("当前消费者线程:" + Thread.currentThread().getName() + ",消费:" + result);
            }, "consumer" + i);
        }

        for(int i = 0 ; i < 10; i++){
            producers[i].start();
        }

        for(int i = 0 ; i < 10; i++){
            consumers[i].start();
        }

    }

}
