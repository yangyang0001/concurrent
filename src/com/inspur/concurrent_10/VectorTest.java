package com.inspur.concurrent_10;

import java.util.Vector;

/**
 * User: YANG
 * Date: 2019/5/7-12:58
 * Description: No Description
 *
 * 原始的并发类容器: Vector HashTable,这种虽然保证了线程的安全性,
 * 但是通过synchronized 虽然保证的了线程的安全性,但是并发的吞吐量太差
 */
public class VectorTest {

    private Vector<String> tickets = new Vector<String>();

    public void add (){
        for(int i=1; i<=10; i++){
            tickets.add("tickets" + i);
        }
    }


    public static void main(String[] args){
        final VectorTest test = new VectorTest();
        test.add();

        for(int i=0; i<10; i++){
            Thread thread = new Thread(() -> {
                while(true){
                    if(test.tickets.size() == 0){
                        break;
                    }
                    System.out.println("当前线程:" + Thread.currentThread().getName() + ",移除:" + test.tickets.remove(0));
                }
            }, "thread" + i);
            thread.start();
        }
    }

}
