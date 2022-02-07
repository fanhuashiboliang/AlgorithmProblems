package com.atguigu.java1;

/**
 * @author denghp
 * @create 2022-02-07 21:38
 */
public class Order<T> {

    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型

    T orderT;

    public Order(){

    }

    public Order(String orderName, int orderId, T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order<?> order = (Order<?>) o;

        if (orderId != order.orderId) return false;
        if (orderName != null ? !orderName.equals(order.orderName) : order.orderName != null) return false;
        return orderT != null ? orderT.equals(order.orderT) : order.orderT == null;
    }

    @Override
    public int hashCode() {
        int result = orderName != null ? orderName.hashCode() : 0;
        result = 31 * result + orderId;
        result = 31 * result + (orderT != null ? orderT.hashCode() : 0);
        return result;
    }
}
