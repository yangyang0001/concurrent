package com.inspur.structure;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-08-25 23:22
 */
public class LambdaTest {

    public static void main(String[] args) {
        List<Integer> firstList = Arrays.asList(10, 3, 5, 4, 11, 8);
        List<Integer> seconList = Arrays.asList(100, 3, 55, 4, 10, 9);

        Arrays.asList(firstList, seconList)
                .stream().flatMap(list -> list.stream())
                .filter(item -> !(firstList.contains(item) && seconList.contains(item)))
                .sorted(Integer::compareTo)
                .forEach(System.out::println);


        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    }
}
