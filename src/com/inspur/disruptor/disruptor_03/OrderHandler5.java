package com.inspur.disruptor.disruptor_03;

import com.lmax.disruptor.EventHandler;

/**
 * User: YANG
 * Date: 2019/5/12-22:37
 * Description: No Description
 */
public class OrderHandler5 implements EventHandler<Order> {
    @Override
    public void onEvent(Order event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("handler5: print instance");
        System.out.println(event);
        Thread.sleep(1000);
    }
}
