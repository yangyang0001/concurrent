package com.inspur.concurrent_back;

import java.util.Random;

/**
 * User: YANG
 * Date: 2019/5/10-10:31
 * Description: No Description
 */
public class MyTest_001_ClassLoader {

    //对下面main方法中的各种打印给出分析
    public static void main(String[] args){
        /**
         * 分析:System.out.println(Child.d);
         *
         *  1.Child.d 属于Child类中的静态变量的引用,符合初始化的条件,对Child类进行初始化,
         *  2.对子类初始化,首先完成对所有父类的初始化!
         *  the last result:
         *      Parent static invoked
         *      Child static invoked
         *      10
         */
//        System.out.println(Child.d);

        /**
         * 分析:System.out.println(Child.c);
         *  1.Child.c属于 Parent中的静态变量,因此只会对Parent进行初始化
         *  the last result:
         *      Parent static invoked
         *      20
         */
//        System.out.println(Child.c);

        /**
         * 分析:System.out.println(Child.b);
         *
         * Child.b属于ChildInterface中的静态常量!并且不属于Child,所以只会对ChildInterface进行初始化
         * the last result:
         *      ChildInterface ....
         */
//        System.out.println(Child.b);

        /**
         * 分析:System.out.println(Child.a);
         *
         * Child.a属于ParentInterface中的静态常量!并且不属于Child,所以只会对ParentInterface进行初始化
         * the last result:
         *      ParentInterface ....
         */
//        System.out.println(Child.a);

        /**
         * 下面的两个属于final类型的常量,这里不会进行类的初始化,直接在编译期就解决了!
         */
        System.out.println(Child.dd);
        System.out.println(Child.cc);

    }
}


interface ParentInterface {
    public int a = new Random().nextInt(10);
    public Thread thread = new Thread(){
        {
            System.out.println("ParentInterface ....");
        }
    };

}

interface ChildInterface extends ParentInterface {
    public int b = new Random().nextInt(10);
    public Thread thread = new Thread(){
        {
            System.out.println("ChildInterface ....");
        }
    };
}

class Parent implements ChildInterface{
    public static int c = 20;
    public final static int cc = 200;
    static {
        System.out.println("Parent static invoked");
    }

}

class Child extends Parent{
    public static int d = 10;
    public final static int dd = 100;
    static {
        System.out.println("Child static invoked");
    }
}