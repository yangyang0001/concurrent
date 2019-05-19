package com.inspur.disruptor.disruptor_03;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: YANG
 * Date: 2019/5/12-22:21
 * Description: No Description
 */
public class Main {

    private static final int threadPoolSize = 4;
    private static final int ringBufferSize = 1024 * 1024;


    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        EventFactory eventFactory = new EventFactory<Order>() {
            @Override
            public Order newInstance() {
                return new Order();
            }
        };

        Disruptor<Order> disruptor = new Disruptor<Order>(eventFactory, ringBufferSize, executorService, ProducerType.SINGLE, new YieldingWaitStrategy());

        //菱形操作
//        disruptor.handleEventsWith(new OrderHandler1(), new OrderHandler2()).then(new OrderHandler3());


        //顺序操作
//        disruptor.handleEventsWith(new OrderHandler1())
//                 .handleEventsWith(new OrderHandler2())
//                 .handleEventsWith(new OrderHandler3());


        //六边形操作.
         OrderHandler1 h1 = new OrderHandler1();
         OrderHandler2 h2 = new OrderHandler2();
         OrderHandler3 h3 = new OrderHandler3();
         OrderHandler4 h4 = new OrderHandler4();
         OrderHandler5 h5 = new OrderHandler5();
         disruptor.handleEventsWith(h1, h2);
         disruptor.after(h1).handleEventsWith(h3);
         disruptor.after(h2).handleEventsWith(h4);
         disruptor.after(h3, h4).handleEventsWith(h5);


        disruptor.start();//启动
        CountDownLatch latch=new CountDownLatch(1);
        //生产者准备
        executorService.submit(new OrderPublisher(latch, disruptor));

        latch.await();//等待生产者完事.

        disruptor.shutdown();
        executorService.shutdown();

    }
}
