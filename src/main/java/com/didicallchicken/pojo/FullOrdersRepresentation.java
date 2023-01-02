package com.didicallchicken.pojo;

import java.math.BigDecimal;

public class FullOrdersRepresentation { //当前用户所有订单信息的表示
     private    Integer orderId;        //订单号
     private    String businessName;    //商家名称
     private    String goodsName;       //商品名称，订单省略页显示第一个点的餐的那种效果
     private    Integer goodsSum;   //商品总数
     private    BigDecimal orderAmount; //商品总花费
     private    String busImg; //商家图片路径
     private    String goodsImg;//商品图片路径

    @Override
    public String toString() {
        return "FullOrdersRepresentation{" +
                "orderId=" + orderId +
                ", businessName='" + businessName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsSum=" + goodsSum +
                ", orderAmount=" + orderAmount +
                ", busImg='" + busImg + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                '}';
    }

    public Integer getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(Integer goodsSum) {
        this.goodsSum = goodsSum;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getBusImg() {
        return busImg;
    }

    public void setBusImg(String busImg) {
        this.busImg = busImg;
    }

    public String getBusinessName() {
                return businessName;
        }

        public void setBusinessName(String businessName) {
                this.businessName = businessName;
        }

        public String getGoodsName() {
                return goodsName;
        }

        public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
        }



        public BigDecimal getOrderAmount() {
                return orderAmount;
        }

        public void setOrderAmount(BigDecimal orderAmount) {
                this.orderAmount = orderAmount;
        }
}
