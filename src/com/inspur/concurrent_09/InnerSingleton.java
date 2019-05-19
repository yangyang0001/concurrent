package com.inspur.concurrent_09;

/**
 * User: YANG
 * Date: 2019/5/7-12:30
 * Description: No Description
 *
 * 这种是在多线程中,最好用也是最安全的单例模式!
 */
public class InnerSingleton {

    private static class Singleton {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return Singleton.instance;
    }

}
