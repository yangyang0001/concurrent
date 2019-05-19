package com.inspur.concurrent_17;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * User: YANG
 * Date: 2019/5/8-16:34
 * Description: No Description
 */
public class Worker implements Runnable {

    private ConcurrentLinkedQueue<Task> concurrentLinkedQueue;
    private ConcurrentHashMap<String, Integer> resultMap;

    public void setConcurrentLinkedQueue(ConcurrentLinkedQueue<Task> concurrentLinkedQueue) {
        this.concurrentLinkedQueue = concurrentLinkedQueue;
    }

    public void ConcurrentHashMap(ConcurrentHashMap<String, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        try {
            while(true){
                Task task = concurrentLinkedQueue.poll();
                if(task == null) {break;}
                //这里用休眠代替执行的具体的任务
                resultMap.put(task.getId(), task.getPrice());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
