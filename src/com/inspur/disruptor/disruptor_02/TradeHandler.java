package com.inspur.disruptor.disruptor_02;

import com.lmax.disruptor.EventHandler;

/**
 * User: YANG
 * Date: 2019/5/11-22:16
 * Description: No Description
 */
public class TradeHandler implements EventHandler<Trade> {
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("event:" + event + ", sequence:" + sequence + ", endOfBatch:" + endOfBatch);
    }
}
