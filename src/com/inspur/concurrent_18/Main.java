package com.inspur.concurrent_18;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: YANG
 * Date: 2019/5/8-21:00
 * Description: No Description
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Data> blockingQueue = new LinkedBlockingQueue<Data>();

        //创建生产者和消费者
        Producer[] producers = new Producer[5];
        Consumer[] consumers = new Consumer[5];

        for(int i = 0; i < producers.length; i++){
            producers[i] = new Producer(blockingQueue);
            consumers[i] = new Consumer(blockingQueue);
        }

        //生产者启动生产
        for(int i = 0; i < 5; i++){
            producers[i].start();
        }

        Thread.currentThread().sleep(5000);

        for(int i = 0; i < 5; i++){
            consumers[i].start();
        }


    }
}
