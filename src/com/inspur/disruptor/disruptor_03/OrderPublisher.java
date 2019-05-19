package com.inspur.disruptor.disruptor_03;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class OrderPublisher implements Runnable {
	
    Disruptor<Order> disruptor;  
    private CountDownLatch latch;  
    
    private static int LOOP=1;//模拟百万次交易的发生
  
    public OrderPublisher(CountDownLatch latch,Disruptor<Order> disruptor) {  
        this.disruptor=disruptor;  
        this.latch=latch;  
    }  
  
    @Override  
    public void run() {  
    	OrderEventTranslator orderTransloator = new OrderEventTranslator();
        for(int i=0;i<LOOP;i++){  
            disruptor.publishEvent(orderTransloator);
        }  
        latch.countDown();  
    }  
      
}

//转换器
class OrderEventTranslator implements EventTranslator<Order>{  
	private Random random=new Random();
	@Override
    public void translateTo(Order event, long sequence) {
        event.setOrderPrice(random.nextDouble()*9999);
    }  

}  