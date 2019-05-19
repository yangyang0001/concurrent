package com.inspur.concurrent_05;

/**
 * User: YANG
 * Date: 2019/5/6-14:53
 * Description: No Description
 */
public class StringLock {

    public void method(){
        //这里使用 字符串常量 作为锁的对象,这里一定要注意 如果 内部是死循环的话 将会阻止其他线程进入当前 代码块!
        //如果使用  new String("字符串对象") 则 就是 不同的 对象锁, 多个线程无法独占
        synchronized (new String("字符串对象")) {
            while (true){
                try {
                    System.out.println("当前线程:" + Thread.currentThread().getName() + "开始");
                    Thread.currentThread().sleep(1000);
                    System.out.println("当前线程:" + Thread.currentThread().getName() + "结束");
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                }
            }
        }
    }

    public static void main(String[] args){
        final StringLock stringLock = new StringLock();

        Thread t1 = new Thread(() -> {
           stringLock.method();
        }, "t1");

        Thread t2 = new Thread(() -> {
           stringLock.method();
        }, "t2");

        t1.start();
        t2.start();
    }

}
