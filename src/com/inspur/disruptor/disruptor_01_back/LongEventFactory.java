package com.inspur.disruptor.disruptor_01_back;

import com.lmax.disruptor.EventFactory;

/**
 * User: YANG
 * Date: 2019/5/11-20:49
 * Description: No Description
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
