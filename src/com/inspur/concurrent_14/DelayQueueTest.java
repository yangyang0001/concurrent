package com.inspur.concurrent_14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * User: YANG
 * Date: 2019/5/8-10:08
 * Description: No Description
 * 提出需求:模拟网民上网的例子!时间到了就下机的一个操作
 */
public class DelayQueueTest {

    public static void main(String[] args){

        DelayQueue<WangMin> delayQueue = new DelayQueue<WangMin>();

        Thread thread1 = new Thread(() -> {
            while(true){
                try {
                    WangMin down = delayQueue.take();
                    System.out.println("网民:" + down.getUsername() + "下机,下机时间:" +
                            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(down.getEndTime())));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            WangMin zhangsan = new WangMin("zhangsan", 1000 + System.currentTimeMillis());
            WangMin lisi = new WangMin("lisi", 10000 + System.currentTimeMillis());
            WangMin wangwu = new WangMin("wangwu", 6000 + System.currentTimeMillis());

            delayQueue.add(zhangsan);
            System.out.println(zhangsan.getUsername() + "在时间:" +
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "上网!");

            delayQueue.add(lisi);
            System.out.println(lisi.getUsername() + "在时间:" +
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "上网!");

            delayQueue.add(wangwu);
            System.out.println(wangwu.getUsername() + "在时间:" +
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "上网!");
            System.out.println("-----------------------------------------------------------");
        });

        thread1.start();
        thread2.start();
    }
}
