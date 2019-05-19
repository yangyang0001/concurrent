package com.inspur.disruptor.disruptor_01;

import com.lmax.disruptor.EventFactory;

/**
 * User: YANG
 * Date: 2019/5/10-16:22
 * Description: No Description
 */
public class LongEventFactory implements EventFactory<LongEvent>{

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
