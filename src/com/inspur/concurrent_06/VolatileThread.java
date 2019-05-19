package com.inspur.concurrent_06;

/**
 * User: YANG
 * Date: 2019/5/6-15:42
 * Description: No Description
 * 本程序主要讲解volatile 在main线程和 其他线程间 对 实例变量 的可见性上的验证,但是它不具备原子性
 *
 */
public class VolatileThread extends Thread{

    /**volatile*/
    private boolean isRunning = true;

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("当前线程:" + Thread.currentThread().getName() + "开始！");
        while(isRunning){
            //do nothing
        }
        System.out.println("当前线程:" + Thread.currentThread().getName() + "结束！");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileThread thread = new VolatileThread();
        thread.start();

        Thread.currentThread().sleep(3000);

        thread.setRunning(false);
        System.out.println(thread.isRunning);
    }
}
