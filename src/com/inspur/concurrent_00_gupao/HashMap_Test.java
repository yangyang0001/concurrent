package com.inspur.concurrent_00_gupao;

import java.util.HashMap;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-08-23 11:30
 *
 * 1.HashMap是什么?
 * 2.源码分析
 * 3.手写实现
 * 4.不足之处
 */
public class HashMap_Test {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("周瑜", "周瑜");
        hashMap.put("诸葛亮", "诸葛亮");
        hashMap.put("司马懿", "司马懿");
        hashMap.put("曹操", "曹操");
        hashMap.put("刘备", "刘备");
        hashMap.put("孙权", "孙权");

        for(String key : hashMap.keySet()) {
            System.out.println("key--->" + key + "的hash值:" + key.hashCode());
        }

    }
}
