package com.inspur.disruptor.disruptor_02_2;

import com.lmax.disruptor.WorkHandler;

/**
 * User: YANG
 * Date: 2019/5/11-22:16
 * Description: No Description
 */
public class TradeHandler implements WorkHandler<Trade> {
    @Override
    public void onEvent(Trade event) throws Exception {
        System.out.println("event:" + event);
    }
}
