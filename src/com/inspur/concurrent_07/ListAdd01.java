package com.inspur.concurrent_07;

import java.util.ArrayList;
import java.util.List;

/**
 * User: YANG
 * Date: 2019/5/6-17:57
 * Description: No Description
 * 是否能够通过用notify 和 wait 对当前程序进行重构呢?
 */
public class ListAdd01 {

    public static volatile List<String> list = new ArrayList<String>();

    public void add(){
        this.list.add("concurrent");
    }

    public int size(){
        return this.list.size();
    }



    public static void main(String[] args){

        final ListAdd01 listAdd01 = new ListAdd01();

        Thread thread1 = new Thread(()-> {
            try {
                for(int i=0; i<10; i++){
                    listAdd01.add();
                    System.out.println("当前线程:" + Thread.currentThread().getName() + "添加了一个元素...");
                    Thread.currentThread().sleep(500);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }
        }, "t1");

        Thread thread2 = new Thread(()-> {
            while(true){
                if(listAdd01.size() == 5){
                    System.out.println("list.size == 5 当前线程:" + Thread.currentThread().getName() + "抛出异常结束");
                    throw new RuntimeException();
                }
            }
        }, "t2");

        thread1.start();
        thread2.start();

    }
}
