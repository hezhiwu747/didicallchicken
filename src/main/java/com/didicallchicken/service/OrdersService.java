package com.didicallchicken.service;

import com.didicallchicken.pojo.FullOrdersRepresentation;
import com.didicallchicken.pojo.OrderInformationDisplay;
import com.didicallchicken.pojo.Orders;

import java.util.List;

public interface OrdersService {

    /**
     * 查询当前用户的所有订单
     * @param userId
     * @return
     */
    List<FullOrdersRepresentation> selectAll(int userId);

    /**
     * 查看单条订单
     * @param orderId
     * @return
     */
    OrderInformationDisplay selectByOrderId(int orderId);

    /**
     * 购买本质上是向订单表插入一条记录，当返回true时，表明交易成功
     * @param order
     * @return
     */
    boolean insertOrder(Orders order);
}
