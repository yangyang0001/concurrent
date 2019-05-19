package com.inspur.concurrent_06;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: YANG
 * Date: 2019/5/6-16:48
 * Description: No Description
 */
public class VolatileNoAtomic extends Thread {

    private volatile static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
//            count++;
            count.incrementAndGet();//配合上面的 AtomicInteger 使用!
        }
        System.out.println(count);
    }

    public static void main(String[] args){

        VolatileNoAtomic[] volatileNoAtomics = new VolatileNoAtomic[10];

        for(int i = 0; i < 10; i++){
            volatileNoAtomics[i] = new VolatileNoAtomic();
        }

        for(int i = 0; i < 10; i++){
            volatileNoAtomics[i].start();
        }
    }
}
