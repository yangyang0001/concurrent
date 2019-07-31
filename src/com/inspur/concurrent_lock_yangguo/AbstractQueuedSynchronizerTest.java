package com.inspur.concurrent_lock_yangguo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: YANG
 * Date: 2019/7/31-14:26
 * Description: No Description
 */
public class AbstractQueuedSynchronizerTest {

	private int count = 0;

	private ReentrantLock lock = new ReentrantLock(true);

	private CountDownLatch countDownLatch;

	public AbstractQueuedSynchronizerTest() {}

	public AbstractQueuedSynchronizerTest(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	private void modifyResources() {
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		lock.lock();
		System.out.println("线程名称:" + Thread.currentThread().getName() + ",第一次加锁!");
		count++;
		System.out.println("线程名称:" + Thread.currentThread().getName() + ",打第" + count + "桶水!");

		lock.lock();
		System.out.println("线程名称:" + Thread.currentThread().getName() + ",第二次加锁!");
		count++;
		System.out.println("线程名称:" + Thread.currentThread().getName() + ",打第" + count + "桶水!");

		lock.unlock();
		System.out.println("线程名称:" + Thread.currentThread().getName() + ",打第一次释放锁!");

		lock.unlock();
		System.out.println("线程名称:" + Thread.currentThread().getName() + ",打第二次释放锁!");

	}

	public static void main(String[] args) {
		int threadCount = 2;

		CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		AbstractQueuedSynchronizerTest aqs = new AbstractQueuedSynchronizerTest(countDownLatch);

		ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
		Thread[] threads = new Thread[threadCount];

		for(int i = 0; i < threadCount; i++){
		    threads[i] = new Thread(() -> {
			    aqs.modifyResources();
		    }, "Yang-Guo-Thread-" + i);
		}

		for(int i = 0; i < threadCount; i++){
			executorService.execute(threads[i]);
			countDownLatch.countDown();
		}

		executorService.shutdown();
	}

}
