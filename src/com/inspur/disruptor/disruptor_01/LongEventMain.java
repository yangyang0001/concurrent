package com.inspur.disruptor.disruptor_01;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: YANG
 * Date: 2019/5/10-16:22
 * Description: No Description
 */
public class LongEventMain {

    public static void main(String[] args){
        //1.构造线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //2.创建事件工厂
        LongEventFactory longEventFactory = new LongEventFactory();
        //3.设置ringBufferSize
//        int ringBufferSize = 1024 * 1024;
        int ringBufferSize = 4;
        //4.ProducerType.

        /**
         *  final EventFactory<T> eventFactory,
            final int ringBufferSize,
            final Executor executor,
            final ProducerType producerType,
            final WaitStrategy waitStrategy)
         */
        Disruptor<LongEvent> disruptor =
                new Disruptor<LongEvent>(longEventFactory, ringBufferSize, executorService, ProducerType.SINGLE, new YieldingWaitStrategy());

        //注册事件处理器EventHandler
        disruptor.handleEventsWith(new LongEventHandler());

        //开启disruptor
        disruptor.start();

        //模仿生产者发布事件
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
//        LongEventProducer producer = new LongEventProducer(ringBuffer);
        //这种方式更加灵活!
        LongEventProducerTransfer producer = new LongEventProducerTransfer(ringBuffer);

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for(int i = 0; i < 100; i++){
            byteBuffer.putLong(0, i);
            producer.onData(byteBuffer);
        }

        //关闭操作
        disruptor.shutdown();
        executorService.shutdown();

    }
}
