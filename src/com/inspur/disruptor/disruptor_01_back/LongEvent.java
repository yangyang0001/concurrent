package com.inspur.disruptor.disruptor_01_back;

/**
 * User: YANG
 * Date: 2019/5/11-20:48
 * Description: No Description
 */
public class LongEvent {

    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[value:" + this.value + "]";
    }
}
