package com.inspur.disruptor.disruptor_03;

import com.lmax.disruptor.EventHandler;

import java.util.UUID;

/**
 * User: YANG
 * Date: 2019/5/12-22:37
 * Description: No Description
 */
public class OrderHandler3 implements EventHandler<Order> {
    @Override
    public void onEvent(Order event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("handler3: set orderId");
        event.setOrderId(event.getOrderId() + "->h3" + UUID.randomUUID().toString());
        Thread.sleep(2000);
    }
}
