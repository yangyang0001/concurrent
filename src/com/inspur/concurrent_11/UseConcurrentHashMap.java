package com.inspur.concurrent_11;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: YANG
 * Date: 2019/5/7-14:41
 * Description: No Description
 * 这里的ConcurrentHashMap 采用的是锁粒度变小的策略 通过 segment进行分段 最多可以分16个段!每一个段相当于一个HashTable
 */
public class UseConcurrentHashMap {

    public static void main(String[] args){
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();

        concurrentHashMap.put("zhangsan", "张三");
        concurrentHashMap.put("lisi", "李四");
        concurrentHashMap.put("wangwu", "王五");
        concurrentHashMap.put("wangwu", "王五123");             //覆盖相同Key的值
        concurrentHashMap.putIfAbsent("wangwu", "kkkkkk");     //putIfAbsent 如果不存在 就设置

        for(Map.Entry<String, String> entry : concurrentHashMap.entrySet()){
            System.out.println(entry.getKey() + "--------" + entry.getValue());
        }
    }

}
