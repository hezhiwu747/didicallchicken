package com.didicallchicken.pojo;

import java.math.BigDecimal;

public class OrderDetalis { //订单详细表示

private        Integer   detailId;    //主键
private        Integer     orderId;   //对应的订单id
private       Integer    goodsId;        //对应的商品id
private       Integer    quantity;       //商品的数量
private       BigDecimal totalPrice; //单价乘以数量得出的价格

    @Override
    public String toString() {
        return "OrderDetalis{" +
                "detailId=" + detailId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }



    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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
}
