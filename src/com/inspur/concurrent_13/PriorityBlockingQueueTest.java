package com.inspur.concurrent_13;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * User: YANG
 * Date: 2019/5/7-22:57
 * Description: No Description
 * 这种有优先级的队列应该是:优先级的
 */
public class PriorityBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {

        PriorityBlockingQueue<MyTask> priorityBlockingQueue = new PriorityBlockingQueue<MyTask>();

        MyTask t1 = new MyTask();
        t1.setId(1);
        t1.setName("任务1");

        MyTask t2 = new MyTask();
        t2.setId(6);
        t2.setName("任务2");

        MyTask t3 = new MyTask();
        t3.setId(4);
        t3.setName("任务3");

        priorityBlockingQueue.add(t1);
        priorityBlockingQueue.add(t2);
        priorityBlockingQueue.add(t3);

        //这里必须保证 出队列的次数,因为 用iterator.hasNext() 会一直为true 这里就循环一定次数把内部的元素进行打印
        int size = priorityBlockingQueue.size();

        for(int i=0; i<size; i++) {
            System.out.println(priorityBlockingQueue);
            //这里必须用queue的take方法才能进行获取到排序后的序列
            System.out.println(priorityBlockingQueue.take().getName());
            System.out.println("------------------------------------");
        }


    }
}
