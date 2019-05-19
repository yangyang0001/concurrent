package com.inspur.disruptor.disruptor_02_2;

/**
 * User: YANG
 * Date: 2019/5/11-22:03
 * Description: No Description
 */
public class Trade {

    private String id;
    private String name;
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ']';
    }
}
