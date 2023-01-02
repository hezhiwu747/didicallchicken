package com.didicallchicken.mapper;

import com.didicallchicken.pojo.Orders;

import java.util.List;

public interface OrdersMapper {

    /**
     * 查询当前用户的所有订单
     * @param userId
     * @return
     */
    List<Orders> selectAll(int userId);

    /**
     * 查看单条订单
     * @param orderId
     * @return
     */
    Orders selectByOrderId(int orderId);

    /**
     * 购买本质上是向订单表插入一条记录，当返回true时，表明交易成功
     * @param order
     * @return
     */
    boolean insertOrder(Orders order);

    /**
     * 计算月售额
     * @param businessId
     */
    void updateMonthlySales(int businessId);

    //取出所有的订单


    List<Orders> selectAllOrder();

    //取出名字
    String getName(int addressId);

    //取出商家
    String getBusinessName(int businessId);

    //取出第一个显示的商品名称
    String getGoodsName(int goodsId);

    //取出商家logo的路径
    String getBusImg(int businessId);

    //取出商品logo的路径
    String getGoodsImg(int goodsId);

    //取出电话
    String getPhone(int addressId);
    //取出地址
    String getAddress(int addressId);

//    void insertTest();
//    Address getAddress(int addressId);


}
