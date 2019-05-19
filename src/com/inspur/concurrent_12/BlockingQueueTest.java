package com.inspur.concurrent_12;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: YANG
 * Date: 2019/5/7-22:08
 * Description: No Description
 */
public class BlockingQueueTest {

    public static void main(String[] args){
/*
        //I.ArrayBlockingQueue 是一个 有界 的 Blocking
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(5);

        arrayBlockingQueue.add("a");
        arrayBlockingQueue.add("b");
        arrayBlockingQueue.add("c");
        arrayBlockingQueue.add("d");
        arrayBlockingQueue.add("e");
//        arrayBlockingQueue.add("f");//将或抛出异常 Queue full, 因为这是有界的

//        System.out.println(arrayBlockingQueue.size());

        arrayBlockingQueue.stream().forEach(System.out::println);
        System.out.println("-------------------------------------------");
        arrayBlockingQueue.peek();  //取出 队列中 第一个元素返回,但是不移除队列
        arrayBlockingQueue.poll();  //取出 队列中 第一个元素返回,并从队列中移除
        arrayBlockingQueue.stream().forEach(System.out::println);

*/

        //II.LinkedBlockingQueue 是一个可选的 阻塞队列 如果构造中填入数量 则有界
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();

        linkedBlockingQueue.add("a");
        linkedBlockingQueue.add("b");
        linkedBlockingQueue.add("c");
        linkedBlockingQueue.add("d");

        linkedBlockingQueue.stream().forEach(System.out::println);



    }
}
