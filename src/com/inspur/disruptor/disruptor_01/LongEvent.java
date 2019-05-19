package com.inspur.disruptor.disruptor_01;

/**
 * User: YANG
 * Date: 2019/5/10-15:37
 * Description: No Description
 * 自定义的传递的数据类型,LongEvent
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
        return  String.valueOf(this.value);
    }
}
