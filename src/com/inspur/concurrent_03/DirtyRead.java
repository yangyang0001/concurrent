package com.inspur.concurrent_03;

/**
 * User: YANG
 * Date: 2019/5/6-12:42
 * Description: No Description
 */
public class DirtyRead {

    public String username = "zhangsan";

    public String password = "123456";

    public synchronized void setValue(){
        try {
            this.username = "zhangsan123";
            this.password = "2017585616";
            Thread.currentThread().sleep(2000);

            System.out.println("setValue invoked --->username:" + this.username + ", password:" + this.password);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }

    public synchronized void getValue(){
        System.out.println("getValue invoked --->username:" + this.username + ", password:" + this.password);
    }


    public static void main(String[] args) throws Exception{
        final DirtyRead dirtyRead = new DirtyRead();

        Thread thread = new Thread(() -> {
            dirtyRead.setValue();
        });

        thread.start();
        Thread.currentThread().sleep(1000);
        dirtyRead.getValue();
    }

}
