package com.inspur.concurrent_00_gupao;

import java.lang.reflect.Field;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-08-23 09:51
 * 注意的点:
 * 1.自动拆箱和装箱的操作
 * 2.IntegerCache的范围 : -128 到 127之间
 * 3.值传递非引用传递
 */
public class Integer_Cache_Test {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1,b = 2;
        System.out.println("a = " + a + ",  b = " + b);
        swap(a, b);
        System.out.println("a = " + a + ",  b = " + b);
    }

    private static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        Integer temp = new Integer(a);//必须new 一个
        field.set(a, b);
        field.set(b, temp);
    }
}
