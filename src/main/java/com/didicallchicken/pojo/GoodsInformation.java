package com.didicallchicken.pojo;

import java.math.BigDecimal;

public class GoodsInformation {


    private  String goodsName;
    private  Integer quantity;       //商品的数量
    private BigDecimal totalPrice;   //单价乘以数量得出的价格
    private  String  goodsImg;       //商品图片路径

    @Override
    public String toString() {
        return "GoodsInformation{" +
                "goodsName='" + goodsName + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", goodsImg='" + goodsImg + '\'' +
                '}';
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }
}
