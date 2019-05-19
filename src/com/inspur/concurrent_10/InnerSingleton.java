package com.inspur.concurrent_10;

/**
 * User: YANG
 * Date: 2019/5/7-14:09
 * Description: No Description
 * 重新复习单例模式, 这种模式在多线程的情况下,是最好用也是安全的!
 */
public class InnerSingleton {

    private static class Singleton {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return Singleton.instance;
    }
}
