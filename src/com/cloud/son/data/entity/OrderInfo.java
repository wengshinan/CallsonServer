package com.cloud.son.data.entity;

/**
 * Created by wengshinan on 15/6/28.
 */
public class OrderInfo {

    private String orderId;
    private OrderStatus status;
    private String orderTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public enum OrderStatus {
        NOTCONFIRMED,
        CONFIRMED,
        PAYED,
        EXECUTED,
        EVALUATED,
        HANGED,
        CANCELED,
        CLOSED,

    }
}
