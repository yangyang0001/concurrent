package com.inspur.threadpool_02;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User: YANG
 * Date: 2019/5/9-10:11
 * Description: No Description
 * 自定义线程池!
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Runnable> blockingQueue = new  ArrayBlockingQueue<Runnable>(2);
//        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>();
//        ArrayBlockingQueue<Runnable> blockingQueue = new  ArrayBlockingQueue<Runnable>(3);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,                                       //int corePoolSize,
                2,                                      //int maximumPoolSize,
                0L,                                      //long keepAliveTime,
                TimeUnit.SECONDS,                        //TimeUnit unit,
                blockingQueue,                           //BlockingQueue<Runnable> workQueue
                new MyRejectedExecutionHandler()
        );

//        Task t1 = new Task("t1", "任务1");
//        Task t2 = new Task("t2", "任务2");
//        Task t3 = new Task("t3", "任务3");
//        Task t4 = new Task("t4", "任务4");
//        Task t5 = new Task("t5", "任务5");
//        Task t6 = new Task("t6", "任务6");
//        Task t7 = new Task("t7", "任务7");

        for(int i = 1; i <= 6; i++){
            Task task = new Task("t"+i, "任务"+i);
            threadPoolExecutor.execute(task);
            System.out.println(i + " " + blockingQueue);

        }

//        threadPoolExecutor.execute(t1);
//        System.out.println("1" + blockingQueue);

//        threadPoolExecutor.execute(t2);
//        System.out.println("2" + blockingQueue);

//        threadPoolExecutor.execute(t3);
//        System.out.println("3" + blockingQueue);

//        threadPoolExecutor.execute(t4);
//        System.out.println("4" + blockingQueue);

//        threadPoolExecutor.execute(t5);
//        System.out.println("5" + blockingQueue);

//        threadPoolExecutor.execute(t6);
//        System.out.println("6" + blockingQueue);

//        threadPoolExecutor.execute(t7);
//        System.out.println("7" + blockingQueue);

        threadPoolExecutor.shutdown();

    }
}
