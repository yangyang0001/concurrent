package com.inspur.structure;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-09-02 16:42
 * 时间复杂度: O(n^2)
 */
public class MaoPaoPaiXu {

    public static void main(String[] args) {

        int[] array = new int[]{1, 3, 11, 4, 22, 44, 5, 99, 100, 10};

        for(int i = 0; i < array.length-i; i++) {
            for(int j = 0; j < array.length - i -1; j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        Arrays.stream(array).forEach(System.out::println);
        System.out.println("------------------------------------------------------");

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(new Thread(() -> {
            System.out.println("-------------------------------");
        }));

    }
}
