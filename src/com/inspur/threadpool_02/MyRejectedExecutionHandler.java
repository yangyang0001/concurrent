package com.inspur.threadpool_02;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: YANG
 * Date: 2019/5/9-14:50
 * Description: No Description
 *
 * 自定义的拒绝策略!
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("执行自定义的决绝策略.....");
        System.out.println("决绝的任务为:" + r);
    }
}
