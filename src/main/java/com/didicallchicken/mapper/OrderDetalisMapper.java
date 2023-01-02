package com.didicallchicken.mapper;

import com.didicallchicken.pojo.OrderDetalis;

import java.util.List;

public interface OrderDetalisMapper {

    /**
     * 用户当前订单的具体信息
     * @param orderId
     * @return
     */
    List<OrderDetalis> selectAllByOrderId(int orderId);

    /*
    当用户购买完成之后，向订单详细表插入对应的商品数据
     */
    void insertOrderDetali(OrderDetalis orderDetalis);

    //取出商品名
    String getGoodsName(int goodsId);

    //取出商品logo的路径
    String getGoodsImg(int goodsId);
}
