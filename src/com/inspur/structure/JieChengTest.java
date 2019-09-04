package com.inspur.structure;

import java.util.Arrays;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-08-24 16:45
 *
 * 对超大数据的思考，可以用一个数组保存每一位,然后再进行操作
 *
 */
public class JieChengTest {


    public static void main(String[] args) {
//        System.out.println(getValueForN(50));
//        long[] lastArr = getValueForN_New(489L, 17L);
//        System.out.println();
//        Arrays.stream(lastArr).forEach(System.out::print);
        long[] resultArr = new long[100];
        resultArr[99] = 1L;

        for(int i = 1; i <= 50 ; i++) {
            resultArr = getValueForN_New(resultArr, i);
        }
        Arrays.stream(resultArr).forEach(System.out::print);

    }

    public static double getValueForN(double n) {
        if(n <= 1) {
            return n;
        }
        return n * getValueForN(n-1);
    }

    public static long[] getValueForN_New(long firstNum, long secondNum) {

        long[] firstArr = new long[50];
        for(int i = 1 ;i < firstArr.length; i++) {
            long wei = (long) (firstNum % Math.pow(10, i));
            firstArr[firstArr.length -i] = wei;
            firstNum = (long) (firstNum / Math.pow(10, i));
        }

        return getValueForN_New(firstArr, secondNum);
    }

    public static long[] getValueForN_New(long[] firstArr, long secondNum) {
        //核心计算
        long jinWei = 0L;
        for(int i = 1 ;i < firstArr.length; i++) {
            long everyBitValue = firstArr[firstArr.length - i] * secondNum + jinWei;
            firstArr[firstArr.length-i] = everyBitValue % 10;
            jinWei = everyBitValue / 10;
        }
        return firstArr;
    }


}
