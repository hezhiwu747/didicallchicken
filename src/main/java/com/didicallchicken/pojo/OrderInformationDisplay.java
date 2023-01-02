package com.didicallchicken.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class OrderInformationDisplay<T> {  //订单的具体信息

    private    String businessName;   //商家
    private    List<T> goodsList;   //商品列表
    private    Integer goodsSum;   //商品总数
    private BigDecimal orderAmount; //商品总花费
    private    String name; //收货人
    private  String  address; //收货地址
    private    String phone; //收货人手机号
    private Timestamp orderDate; //下单时间

    @Override
    public String toString() {
        return "OrderInformationDisplay{" +
                "businessName='" + businessName + '\'' +
                ", goodsList=" + goodsList +
                ", goodsSum=" + goodsSum +
                ", orderAmount=" + orderAmount +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }

    public Integer getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(Integer goodsSum) {
        this.goodsSum = goodsSum;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public List<T> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<T> goodsList) {
        this.goodsList = goodsList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
