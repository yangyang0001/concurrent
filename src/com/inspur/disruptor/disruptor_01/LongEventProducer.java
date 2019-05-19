package com.inspur.disruptor.disruptor_01;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * User: YANG
 * Date: 2019/5/10-16:37
 * Description: No Description
 */
public class LongEventProducer {

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer byteBuffer) {
        //1.获取下一个事件槽
        long sequence = ringBuffer.next();
        try {
            //2.在ringBuffer中取出空的事件,等待填充数据
            LongEvent longEvent = ringBuffer.get(sequence);
            //3.为事件填充值
            longEvent.setValue(byteBuffer.getLong(0));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //4.发布事件
            ringBuffer.publish(sequence);
        }

    }


}
