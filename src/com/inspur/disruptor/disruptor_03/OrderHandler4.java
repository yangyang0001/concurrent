package com.inspur.disruptor.disruptor_03;

import com.lmax.disruptor.EventHandler;

/**
 * User: YANG
 * Date: 2019/5/12-22:37
 * Description: No Description
 */
public class OrderHandler4 implements EventHandler<Order> {
    @Override
    public void onEvent(Order event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("handler4: set orderName");
        event.setOrderName(event.getOrderName() + "->h4-orderName-智能手机");
        Thread.sleep(1000);
    }
}
