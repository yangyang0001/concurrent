package com.inspur.concurrent_17;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * User: YANG
 * Date: 2019/5/8-16:30
 * Description: No Description
 */
public class Master {

    //1.存放子线程的集合
    private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<Task>();

    //2.工作Thread集合
    private HashMap<String, Thread> workers = new HashMap<String ,Thread>();

    //3.worker处理完结果后的并发集合
    private ConcurrentHashMap<String, Integer> resultMap = new ConcurrentHashMap<String, Integer>();

    //4.构造方法初始化wokers, taskQueue
    public Master (Worker worker, int allWorkerCount){
        Random random = new Random();
        //初始化taskQueue
        for(int i = 0; i < 1000; i++){
            Task task = new Task("" + i, "task" + i, random.nextInt(1000));
            taskQueue.add(task);
        }
        //初始化workers
        for(int i = 1; i <= allWorkerCount; i++){
            worker.setConcurrentLinkedQueue(taskQueue);
            worker.ConcurrentHashMap(resultMap);
            workers.put("worker" + i, new Thread(worker));
        }
    }

    //5.worker中的线程执行任务
    public void execute(){
        for(Map.Entry<String, Thread> worker : workers.entrySet()){
            worker.getValue().start();
        }
    }

    private boolean isComputed() {
        while(true){
            for(Map.Entry<String, Thread> worker : workers.entrySet()){
                if(worker.getValue().getState() != Thread.State.TERMINATED){
                    return false;
                }
            }
            return true;
        }
    }

    public int getLastResult(){
        int ret = 0;
        while(!isComputed()){
            //do nothing 进行等待
        }
        for(Map.Entry<String, Integer> resultEntry : resultMap.entrySet()){
            ret += resultEntry.getValue();
        }
        return ret;
    }

}
