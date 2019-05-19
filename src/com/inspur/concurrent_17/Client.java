package com.inspur.concurrent_17;

/**
 * User: YANG
 * Date: 2019/5/8-17:03
 * Description: No Description
 */
public class Client {

    public static void main(String[] args){
        Master master = new Master(new Worker(), 8);
        long start = System.currentTimeMillis();
        master.execute();
        int lastResult = master.getLastResult();
        long end = System.currentTimeMillis();
        System.out.println("result:" + lastResult + ",执行时间:" + (end - start));
    }
}
