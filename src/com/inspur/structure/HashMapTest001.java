package com.inspur.structure;

import java.util.HashMap;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-09-04 20:05
 */
public class HashMapTest001 {

    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<String, String>(13);

        hashMap.put("aa", "bb");
        hashMap.put("aa", "ccc");

        System.out.println(hashMap.get("aa"));


    }

}
