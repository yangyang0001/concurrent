package com.inspur.concurrent_17;

/**
 * User: YANG
 * Date: 2019/5/8-16:39
 * Description: No Description
 */
public class Task {
    //ID
    private String id;
    //名称
    private String name;
    //价格
    private int price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Task(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
