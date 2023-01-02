package com.didicallchicken.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Orders<T> {   //订单
    private    Integer orderId;
    private    Integer userId;
    private     Integer      businessId;
    private    Timestamp orderDate;
    private     BigDecimal orderAmount;
    private     Integer addressId;
    private     List<T>   orderDetalis;
    private     Integer   goodsSum;

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", businessId=" + businessId +
                ", orderDate=" + orderDate +
                ", orderAmount=" + orderAmount +
                ", addressId=" + addressId +
                ", orderDetalis=" + orderDetalis +
                ", goodsSum=" + goodsSum +
                '}';
    }

    public Integer getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(Integer goodsSum) {
        this.goodsSum = goodsSum;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public List<T> getOrderDetalis() {
        return orderDetalis;
    }

    public void setOrderDetalis(List<T> orderDetalis) {
        this.orderDetalis = orderDetalis;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }



    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }
}
