package com.inspur.disruptor.disruptor_01;

import com.lmax.disruptor.EventHandler;

/**
 * User: YANG
 * Date: 2019/5/10-16:17
 * Description: No Description
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        Thread.currentThread().sleep(1000);
        System.out.println("event:" + event + ", sequence:" + sequence + ", endOfBatch:" +endOfBatch);
    }
}
