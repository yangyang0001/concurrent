package com.inspur.disruptor.disruptor_02;

import com.lmax.disruptor.*;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * User: YANG
 * Date: 2019/5/11-22:07
 * Description: No Description
 */
public class Main {

    private static final int ringBufferSize = 1024 * 1024;
    private static final int threadPoolSize = 4;

    public static void main(String[] args) throws Exception{

        //直接使用ringBuffer
        final RingBuffer<Trade> ringBuffer = RingBuffer.createSingleProducer(new EventFactory<Trade>() {
            @Override
            public Trade newInstance() {
                return new Trade();
            }
        }, ringBufferSize, new YieldingWaitStrategy());

        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        //创建消息处理器
        BatchEventProcessor<Trade> processor =
                new BatchEventProcessor<Trade>(ringBuffer, sequenceBarrier, new TradeHandler());
        //将消费者的sequence 注入到 生产者中
        ringBuffer.addGatingSequences(processor.getSequence());
        //将消息处理器 通过线程池 运行
        executorService.submit(processor);
        //如果存在多个消费者 那重复执行上面3行代码 把TradeHandler换成其它消费者类

        //生产者,同样用一个线程池来执行!
        Future future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                long sequence;
                Random random = new Random();
                for(int i = 0; i < 10; i++){
                    sequence = ringBuffer.next();
                    Trade trade = ringBuffer.get(sequence);
                    trade.setId(UUID.randomUUID().toString());
                    trade.setName("玩具" + i);
                    trade.setPrice(random.nextDouble() * 1000);

                    ringBuffer.publish(sequence);
                }
                return null;
            }
        });


        future.get();               //等待生产者结束
        Thread.sleep(1000);         //等上1秒，等消费都处理完成
        processor.halt();           //通知事件(或者说消息)处理器 可以结束了（并不是马上结束!!!）
        executorService.shutdown(); //终止线程

    }

}
