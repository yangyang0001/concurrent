package com.inspur.threadpool_02;

/**
 * User: YANG
 * Date: 2019/5/9-10:11
 * Description: No Description
 */
public class Task extends Thread {

    private String taskID;

    private String taskName;

    public Task(String taskID, String taskName) {
        this.taskID = taskID;
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            System.out.println("执行--------->" + this);
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "[this.taskID:" + this.getTaskID() + ", this.taskName:" + this.getTaskName() + "]";
    }
}
