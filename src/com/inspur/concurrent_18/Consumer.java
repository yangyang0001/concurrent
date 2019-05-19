package com.inspur.concurrent_18;

import java.util.concurrent.BlockingQueue;

/**
 * User: YANG
 * Date: 2019/5/8-21:02
 * Description: No Description
 */
public class Consumer extends Thread {

    private BlockingQueue<Data> blockingQueue;

    public Consumer(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                if(blockingQueue.size() == 0){
                    break;
                }
                Data data = blockingQueue.take();
                System.out.println("当前消费线程:" + Thread.currentThread().getName() + ",消费数据:" + data);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
