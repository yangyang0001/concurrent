package com.inspur.concurrent_16;

/**
 * User: YANG
 * Date: 2019/5/8-14:12
 * Description: No Description
 * Class:真实的数据
 */
public class RealData {

    private String realContext;

    public RealData (String realContext) {
        this.realContext = realContext;
        System.out.println("获取真实的RealData,这个过程可能会很长时间....");
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getRealContext() {
        return realContext;
    }

    public void setRealContext(String realContext) {
        this.realContext = realContext;
    }
}
