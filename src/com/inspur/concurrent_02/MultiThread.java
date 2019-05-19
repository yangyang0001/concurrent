package com.inspur.concurrent_02;

/**
 * 本程序总结:
 *      1.一个对象有一把锁, 如果synchronized 修饰的是 非静态的方法 就是修饰的调用当前方法的实例的锁,或叫对象锁
 *      2.如果synchronized 修饰的是类Class级别的锁,叫类锁!这时无论如果有多少个对象调用当前的方法,独占当前Class锁
 */
public class MultiThread {

    private static int num = 0;

    public static synchronized void printNum(String tag){
        try {

            if("a".equals(tag)){
                num = 100;
                System.out.println("tag a, num is :" + num);
            } else {
                num = 200;
                System.out.println("tag other, num is :" + num);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }

    //观察 不同的 run() 执行的顺序的不同!
    public static void main(String[] args){
        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();

        Thread t1 = new Thread(() -> {
            m1.printNum("a");
        });

        Thread t2 = new Thread(() -> {
            m2.printNum("b");
        });

        t1.start();
        t2.start();
    }
}
