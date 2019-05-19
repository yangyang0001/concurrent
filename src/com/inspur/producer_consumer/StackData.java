package com.inspur.producer_consumer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: YANG
 * Date: 2019/5/9-8:37
 * Description: No Description
 */
public class StackData {

    //1.定义仓库类型的容器
    public final int[] array = new int[6];

    //2.定义容器中的计数器
    private AtomicInteger count = new AtomicInteger(0);

    //3.定义仓库的最大容量
    private final int maxSize = 6;

    //4.定义仓库的最小容量
    private final int minSize = 0;

    //5.定义一个lock
    private final Object lock = new Object();

    public void put(int input){
        synchronized (lock) {
            try {
                //判断仓库是否满了,如果满了 等待
                while(count.get() == maxSize){
                    lock.wait();
                }

                //没有满的情况下,进行压栈操作
                System.out.println("当前生产线程:" + Thread.currentThread().getName() + ",生产:" + input);
                array[count.get()] = input;
                count.incrementAndGet();

                lock.notifyAll();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    public int get(){
        synchronized (lock) {
            int result = Integer.MIN_VALUE;
            try {
                //判断仓库是否是空的
                if(count.get() == minSize) {
                    lock.wait();
                }
                //执行出栈操作
                result = array[count.get() -1];
                count.decrementAndGet();

                lock.notifyAll();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return result;
        }
    }
}
