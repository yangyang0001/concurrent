package com.inspur.concurrent_09;

/**
 * User: YANG
 * Date: 2019/5/7-11:43
 * Description: No Description
 * ThreadLocal 相当于一个Map<Thread, T> map 类型,这种情况下 以线程为Key, T类型的值为value 所以会产生覆盖的情况!
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public void put(String content){
        threadLocal.set(content);
    }

    public String get(){
        return threadLocal.get();
    }

    public static void main(String[] args){

        final ThreadLocalTest test = new ThreadLocalTest();

        Thread thread1 = new Thread(() -> {
            test.put("aaa");
            test.put("bbb");
            test.put("ccc");
            System.out.println("线程:" + Thread.currentThread().getName() + ",threadLocal.get():" + test.get());
            System.out.println("线程:" + Thread.currentThread().getName() + ",threadLocal.get():" + test.get());
            System.out.println("线程:" + Thread.currentThread().getName() + ",threadLocal.get():" + test.get());
        }, "t1");

        Thread thread2 = new Thread(() -> {
            System.out.println("线程:" + Thread.currentThread().getName() + ",threadLocal.get():" + test.get());
        }, "t2");


        thread1.start();
        thread2.start();
    }

}
