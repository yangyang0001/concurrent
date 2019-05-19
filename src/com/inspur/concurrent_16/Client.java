package com.inspur.concurrent_16;

/**
 * User: YANG
 * Date: 2019/5/8-14:09
 * Description: No Description
 *
 * 模拟Future的获取值的过程!
 *
 * Client -> FutureData 并返回这个包装体! (FutureData是真实数据RealData的一个包装体, 内部悄悄地去获取真实的数据)
 *
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        FutureData futureData = FutureData.getRequest("every_queryString");
        System.out.println("客户端去做其他的事情......start");
        Thread.currentThread().sleep(10000);
        System.out.println("客户端去做其他的事情......  end");
        RealData realData = futureData.getRealData();
        System.out.println(realData.getRealContext());
    }

}
