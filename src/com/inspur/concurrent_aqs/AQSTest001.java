package com.inspur.concurrent_aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * User: YANG
 * Date: 2019/8/6-14:52
 * Description: No Description
 */
public class AQSTest001 {

	public static int m = 0;

	public static void main(String[] args) throws Exception{

		Thread[] threads = new Thread[100];

		for(int i = 0; i < threads.length; i++){
		    threads[i] = new Thread(() ->{
		    	for(int j = 0; j < 100; j++){
				    ReentrantLock lock = new ReentrantLock();
		    	    m++;
		    	}
		    });
		}

		for (Thread thread : threads) {
			thread.start();
		}

		for (Thread thread : threads) {
			thread.join();// 让线程顺序结束
		}

		System.out.println(m);

	}
}
