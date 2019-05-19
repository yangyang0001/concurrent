package com.inspur.disruptor.disruptor_02_2;

import com.lmax.disruptor.*;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: YANG
 * Date: 2019/5/11-22:45
 * Description: No Description
 */
public class Main {
    private static final int ringBufferSize = 1024 * 1024;
    private static final int threadPoolSize = 4;


    public static void main(String[] args) throws InterruptedException {

        EventFactory<Trade> eventFactory = new EventFactory<Trade>() {
            @Override
            public Trade newInstance() {
                return new Trade();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        final RingBuffer<Trade> ringBuffer = RingBuffer.createSingleProducer(eventFactory, ringBufferSize, new YieldingWaitStrategy());

        SequenceBarrier sequenceBarrier =  ringBuffer.newBarrier();

        WorkHandler workHandler = new TradeHandler();

        WorkerPool<Trade> workerPool = new WorkerPool<Trade>(ringBuffer, sequenceBarrier, new IgnoreExceptionHandler(), workHandler);

        workerPool.start(executorService);


        Random random = new Random();
        for(int i = 0; i < 10; i++){
            long sequence = ringBuffer.next();
            Trade trade = ringBuffer.get(sequence);
            trade.setId(UUID.randomUUID().toString());
            trade.setName("玩具" + i);
            trade.setPrice(random.nextDouble() * 1000);
            ringBuffer.publish(sequence);
        }

        Thread.sleep(1000);
        workerPool.halt();
        executorService.shutdown();
    }

}
