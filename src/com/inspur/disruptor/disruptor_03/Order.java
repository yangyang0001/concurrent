package com.inspur.disruptor.disruptor_03;

import java.io.Serializable;

/**
 * User: YANG
 * Date: 2019/5/12-22:22
 * Description: No Description
 */
public class Order implements Serializable{

    private static final long serialVersionUID = 3515687189502274643L;

    private String orderId;
    private String orderName;
    private double orderPrice;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
