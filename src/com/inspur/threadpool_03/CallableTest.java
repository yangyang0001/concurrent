package com.inspur.threadpool_03;

import java.util.concurrent.*;

/**
 * User: YANG
 * Date: 2019/5/9-18:29
 * Description: No Description
 * executorService.submit() 和 execute() 方法的区别:
 * 1.submit() 能够执行 Callable,Runnable接口的实例对象
 * 2.submit() 有返回值, execute() 没有返回值
 */
public class CallableTest {

    public static void main(String[] args) throws InterruptedException {

        try {
            FutureTask<String> futureTask1 = new FutureTask(new MyTask());
            FutureTask<String> futureTask2 = new FutureTask(new MyTask());
            ExecutorService executorService = Executors.newCachedThreadPool();

            Future future1= executorService.submit(futureTask1);
            Future future2= executorService.submit(futureTask2);

            System.out.println("do something");
            Thread.currentThread().sleep(5000);

            System.out.println(futureTask1.get());
            System.out.println(futureTask2.get());

            executorService.shutdown();
        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }
}

class MyTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.currentThread().sleep(5000);
        return "通过call()返回的结果String";
    }
}
