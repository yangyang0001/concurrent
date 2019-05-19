package com.inspur.concurrent_18;

import java.util.concurrent.BlockingQueue;

/**
 * User: YANG
 * Date: 2019/5/8-21:02
 * Description: No Description
 */
public class Producer extends Thread {

    private BlockingQueue<Data> blockingQueue;

    public Producer(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            Data data = new Data("id" + i, "name" + i);
            System.out.println("当前生产线程:" + Thread.currentThread().getName() + ",生产数据:" + data);
            blockingQueue.add(data);
        }
    }
}
