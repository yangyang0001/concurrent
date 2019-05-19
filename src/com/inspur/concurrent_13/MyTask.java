package com.inspur.concurrent_13;

/**
 * User: YANG
 * Date: 2019/5/7-23:00
 * Description: No Description
 */
public class MyTask implements Comparable<MyTask>{

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(MyTask o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "[id:" + this.getId() + ",name:" + this.getName() + "]";
    }
}
