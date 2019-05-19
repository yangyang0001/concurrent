package com.inspur.disruptor.disruptor_01_back;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: YANG
 * Date: 2019/5/11-20:53
 * Description: No Description
 */
public class Main {

    public static void main(String[] args){

        EventFactory eventFactory = new LongEventFactory();
        int ringBufferSize = 1024 * 1024;
        ExecutorService executorService = Executors.newCachedThreadPool();
        ProducerType producerType = ProducerType.SINGLE;
        WaitStrategy waitStrategy = new YieldingWaitStrategy();

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory, ringBufferSize, executorService,
                producerType, waitStrategy);

        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        for(int i = 0; i < 100; i++){
            byteBuffer.putLong(0, i);
            producer.onData(byteBuffer);
        }

        disruptor.shutdown();
        executorService.shutdown();
    }

}
