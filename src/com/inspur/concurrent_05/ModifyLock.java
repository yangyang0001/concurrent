package com.inspur.concurrent_05;

/**
 * User: YANG
 * Date: 2019/5/6-15:27
 * Description: No Description
 * 这就是Object 实例类型的锁, 在运行过程中进行修改, 其锁不会发生改变
 */
public class ModifyLock {

    public String username;

    public String password;

    public synchronized void changeAttribute(String username, String password){
        try {
            System.out.println("当前线程: " + Thread.currentThread().getName() + "开始");
            Thread.currentThread().sleep(2000);
            this.username = username;
            this.password = password;
            System.out.println("当前线程: " + Thread.currentThread().getName() + "结束");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }

    public static void main(String[] args){
        final ModifyLock modifyLock = new ModifyLock();

        Thread thread1 = new Thread(() -> {
            modifyLock.changeAttribute("张三", "123456");
        });

        Thread thread2 = new Thread(() -> {
            modifyLock.changeAttribute("李四", "2017585616");
        });

        thread1.start();
        thread2.start();
    }

}
