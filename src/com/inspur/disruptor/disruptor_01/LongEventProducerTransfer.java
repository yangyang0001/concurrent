package com.inspur.disruptor.disruptor_01;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * User: YANG
 * Date: 2019/5/10-17:34
 * Description: No Description
 */
public class LongEventProducerTransfer {

    private final RingBuffer<LongEvent> ringBuffer;
    public LongEventProducerTransfer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR = new EventTranslatorOneArg<LongEvent, ByteBuffer>(){
        @Override
        public void translateTo(LongEvent event, long sequence, ByteBuffer buffer) {
            event.setValue(buffer.getLong(0));
        }
    };

    public void onData(ByteBuffer byteBuffer){
        ringBuffer.publishEvent(TRANSLATOR, byteBuffer);
    }


}
