package com.inspur.disruptor.disruptor_01_back;

import com.lmax.disruptor.EventHandler;

/**
 * User: YANG
 * Date: 2019/5/11-20:50
 * Description: No Description
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("event:" + event + ", sequence:" + sequence + ", endOfBatch:" + endOfBatch);
    }
}
