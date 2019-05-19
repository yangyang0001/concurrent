package com.inspur.concurrent_11;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * User: YANG
 * Date: 2019/5/7-18:13
 * Description: No Description
 * CopyOnWriteArrayList 和 CopyOnWriteArraySet 的用法和原始的 ArrayList HashSet 用法一样!
 * 只不过这里是 读多写少 情况下 最适合使用 CopyOnWrite
 */
public class UseCopyOnWrite {

    public static void main(String[] args){

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<String>();

        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");

        set.add("aaa");
        set.add("aaa");

        list.stream().forEach(System.out::println);
        System.out.println("------------------------------------");
        set.stream().forEach(System.out::println);
    }
}
