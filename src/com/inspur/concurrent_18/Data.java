package com.inspur.concurrent_18;

/**
 * User: YANG
 * Date: 2019/5/8-21:00
 * Description: No Description
 * 阻塞队列中的数据
 */
public class Data {

    private String id;
    private String name;

    public Data(String id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "[id:" + this.getId() + ", name:" + this.getName() + "]";
    }
}
