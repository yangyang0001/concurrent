package com.inspur.concurrent_16;

/**
 * User: YANG
 * Date: 2019/5/8-14:11
 * Description: No Description
 * Class: 真实数据RealData的一个包装体
 */
public class FutureData {

    private RealData realData;

    public RealData getRealData() {
        return realData;
    }

    public void setRealData(RealData realData) {
        this.realData = realData;
    }

    //创建一个获取的真实数据包装体的方法
    public static FutureData getRequest(String queryString){
        System.out.println("接收到请求...");
        FutureData futureData = new FutureData();

        new Thread(() -> {
            RealData realData = futureData.doGetRealData(queryString);
            futureData.setRealData(realData);
        }).start();

        return futureData;
    }

    private RealData doGetRealData(final String queryString){
        return new RealData("这是真实的RealData");
    }
}
