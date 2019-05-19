package com.inspur.concurrent_04;

/**
 * User: YANG
 * Date: 2019/5/6-13:32
 * Description: No Description
 * 本类:主要讲解synchronized 是一种可重入锁!
 */
public class SynchronizedDouble01 {

    public void method1(){
        System.out.println("method1...");
        method2();
    }

    private void method2() {
        System.out.println("method2...");
        method3();
    }

    private void method3() {
        System.out.println("method3...");
    }

    public static void main(String[] args){
        final SynchronizedDouble01 sync = new SynchronizedDouble01();

        Thread thread = new Thread(() -> {
            sync.method1();
        });

        thread.start();
    }

}
