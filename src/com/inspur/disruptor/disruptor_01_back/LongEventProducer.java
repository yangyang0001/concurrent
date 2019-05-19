package com.inspur.disruptor.disruptor_01_back;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * User: YANG
 * Date: 2019/5/11-20:52
 * Description: No Description
 */
public class LongEventProducer {

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer byteBuffer) {
        long sequence = ringBuffer.next();
        LongEvent longEvent = ringBuffer.get(sequence);
        try {
            longEvent.setValue(byteBuffer.getLong(0));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
