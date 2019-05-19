package com.inspur.threadpool_01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * User: YANG
 * Date: 2019/5/8-22:57
 * Description: No Description
 */
public class ScheduleThreadPool {

    public static void main(String[] args){
        Temp temp = new Temp();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        //下一个任务的开始时间为: 上一个任务结束的时间+延迟时间 的时间点
//        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(temp, 1, 5, TimeUnit.SECONDS);

        //下一个任务执行的时间为: 上一个任务完成的时间 > 延迟时间 则立即执行, 否则就是按给定的间隔时间执行
        scheduledExecutorService.scheduleAtFixedRate(temp, 1, 5, TimeUnit.SECONDS);
    }
}

class Temp extends Thread {
    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(6000);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
