package com.inspur.structure;

import java.util.Arrays;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-08-25 22:22
 */
public class TestInsertPaiXu {

    public static void main(String[] args) {
        insertSort();
    }

    public static void insertSort() {

        int[] arr = new int[]{10, 3, 2, 4, 5,10, 6};

        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j <= i - 1; j++) {
                if(arr[j] > arr[i]) {
                    //保存 i 位置的值
                    int temp = arr[i];
                    //向后移动
                    for(int k = i ; k >= j+1; k--) {
                        arr[k] = arr[k-1];
                    }
                    //插入
                    arr[j] = temp;
                }
            }
        }

        Arrays.stream(arr).forEach(System.out::println);
    }
}


