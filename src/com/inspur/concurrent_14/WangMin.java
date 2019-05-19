package com.inspur.concurrent_14;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * User: YANG
 * Date: 2019/5/8-10:17
 * Description: No Description
 */
public class WangMin implements Delayed {

    private String username;
    private long endTime;       //上网结束时间,这里用毫秒表示

    public WangMin(String username, long endTime) {
        this.username = username;
        this.endTime = endTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {//获取剩余时间   已被take() 获取
        return unit.convert(endTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {   //类似与PriorityBlockingQueue 根据上网的结束时间 take() 时进行排序
        WangMin other = (WangMin) o;
        return this.endTime > other.getEndTime() ? 1 : (this.endTime < other.getEndTime() ? -1 : 0);
    }
}
