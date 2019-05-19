package com.inspur.disruptor.disruptor_03;

import com.lmax.disruptor.EventHandler;

/**
 * User: YANG
 * Date: 2019/5/12-22:37
 * Description: No Description
 */
public class OrderHandler2 implements EventHandler<Order> {
    @Override
    public void onEvent(Order event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("handler2: set orderName");
        event.setOrderName("h2-orderName-苹果手机");
        Thread.sleep(1000);
    }
}
