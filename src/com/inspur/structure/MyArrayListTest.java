package com.inspur.structure;

import java.util.ArrayList;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-08-25 17:39
 * 手写 ArrayList
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        for (int i = 0; i < 8; i++) {
        	list.add("zhangsan" + i);
        }
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list.size());
    }
}


class MyArrayList<T> {

    //首先定义一个数组:
    Object[] objects = new Object[4];

    private int size = 0;

    public void add(T value) {

        if(size >= objects.length) {
            //创建一个新的数组
            Object[] newObjects = new Object[objects.length * 2];
            for(int i = 0; i < objects.length; i++) {
                newObjects[i] = objects[i];
            }
            objects = newObjects;
        }
        objects[size] = value;
        size++;

    }

    public void set(int index, T value) {
        if(index < 0 || index >= size) {
            //说明已经超越了 已经放的数量
            throw new ArrayIndexOutOfBoundsException();
        }
        objects[index] = value;

    }

    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) objects[index];
    }

    public void clear() {
        size = 0;
        objects = new Object[4];
    }

    public void remove(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = index + 1; i < size; i++) {
            objects[i-1] = objects[i];
        }

        size--;
    }

    public int size() {
        return this.size;
    }
}