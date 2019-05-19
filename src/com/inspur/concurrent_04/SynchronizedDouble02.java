package com.inspur.concurrent_04;

/**
 * User: YANG
 * Date: 2019/5/6-13:32
 * Description: No Description
 * 本类:主要讲解synchronized 是一种可重入锁!
 * 这种方式也是可以的!
 */
public class SynchronizedDouble02 {

    static class Main {
        public int i = 10;
        public synchronized void operationMain(){
            i --;
            System.out.println("ThreadName:" + Thread.currentThread().getName() + ",Main print i is:" + i);
        }
    }

    static class Sub extends Main {
        public synchronized void operationSub(){
            while(this.i > 0){
                this.i --;
                System.out.println("ThreadName:" + Thread.currentThread().getName() + ",Sub print i is:" + this.i);
                operationMain();
            }
        }
    }



    public static void main(String[] args) throws Exception{
        Sub sub = new Sub();

        Thread t1 = new Thread(() -> {
            sub.operationSub();
        }, "t1");

        Thread t2 = new Thread(() -> {
            sub.operationSub();
        }, "t2");

        Thread t3 = new Thread(() -> {
            sub.operationSub();
        }, "t3");

        Thread t4 = new Thread(() -> {
            sub.operationSub();
        }, "t4");

        Thread t5 = new Thread(() -> {
            sub.operationSub();
        }, "t5");

        Thread.sleep(1000);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

}
