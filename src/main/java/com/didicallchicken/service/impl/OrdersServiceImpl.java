package com.didicallchicken.service.impl;

import com.didicallchicken.mapper.OrderDetalisMapper;
import com.didicallchicken.mapper.OrdersMapper;
import com.didicallchicken.pojo.*;
import com.didicallchicken.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
   private OrdersMapper mapper;
    @Autowired
   private OrderDetalisMapper orderDetalisMapper;
    //查看当前用户的所有订单
    @Override
    public List<FullOrdersRepresentation> selectAll(int userId) {
        //当前用户所有订单信息列表
        List<FullOrdersRepresentation> fullOrdersRepresentationList = new ArrayList<>();
        //当前用户所有订单表示
        List<Orders> orders = mapper.selectAll(userId);

        for(int i = 0;i<orders.size();i++){
            Orders order = orders.get(i);
            List<OrderDetalis> orderDetalisList = orderDetalisMapper.selectAllByOrderId(order.getOrderId());
            order.setOrderDetalis(orderDetalisList);
            List orderDetalis = order.getOrderDetalis();
            Object o = orderDetalis.get(i-i);
            OrderDetalis detalis =  (OrderDetalis) o;
            FullOrdersRepresentation fullOrdersRepresentation = new FullOrdersRepresentation();
            //设置订单id
            fullOrdersRepresentation.setOrderId(order.getOrderId());
            fullOrdersRepresentation.setBusinessName(mapper.getBusinessName(order.getBusinessId()));
            fullOrdersRepresentation.setGoodsName(mapper.getGoodsName(detalis.getGoodsId()));//
            fullOrdersRepresentation.setBusImg(mapper.getBusImg(order.getBusinessId()));
            fullOrdersRepresentation.setGoodsImg(mapper.getGoodsImg(detalis.getGoodsId()));
            fullOrdersRepresentation.setGoodsSum(order.getGoodsSum());
            fullOrdersRepresentation.setOrderAmount(order.getOrderAmount());
            fullOrdersRepresentationList.add(fullOrdersRepresentation);
        }
        return fullOrdersRepresentationList;
    }

    @Override
    public OrderInformationDisplay selectByOrderId(int orderId) {
        //订单详情页
        OrderInformationDisplay orderInformationDisplay = new OrderInformationDisplay();
        //订单详情页商品列表
        List<GoodsInformation> goodsListInformationList = new ArrayList<>();
        //订单
        Orders order = mapper.selectByOrderId(orderId);
        //地址
        orderInformationDisplay.setAddress(mapper.getAddress(order.getAddressId()));
        //商家
        orderInformationDisplay.setBusinessName(mapper.getBusinessName(order.getBusinessId()));
        //总数
        orderInformationDisplay.setGoodsSum(order.getGoodsSum());
        //收货人
        orderInformationDisplay.setName(mapper.getName(order.getAddressId()));
        //总花费
        orderInformationDisplay.setOrderAmount(order.getOrderAmount());
        //下单日期
        orderInformationDisplay.setOrderDate(order.getOrderDate());
        //手机号码
        orderInformationDisplay.setPhone(mapper.getPhone(order.getAddressId()));
        //订单详情表，取出商品列表
        List<OrderDetalis> orderDetalis = orderDetalisMapper.selectAllByOrderId(orderId);
        //遍历商品列表
        for (int i = 0; i < orderDetalis.size(); i++) {
            OrderDetalis detalis = orderDetalis.get(i);
            GoodsInformation goodsInformation = new GoodsInformation();
//            goodsInformation.setGoodsId(detalis.getGoodsId());
//            goodsInformation.setGoodsId(detalis.getGoodsId());
            goodsInformation.setGoodsImg(orderDetalisMapper.getGoodsImg(detalis.getGoodsId()));
            goodsInformation.setGoodsName(orderDetalisMapper.getGoodsName(detalis.getGoodsId()));
            goodsInformation.setQuantity(detalis.getQuantity());
            goodsInformation.setTotalPrice(detalis.getTotalPrice());
            goodsListInformationList.add(goodsInformation);
        }
        //设置商品列表
        orderInformationDisplay.setGoodsList(goodsListInformationList);
        return orderInformationDisplay;
    }

    @Override
    public boolean insertOrder(Orders order) {
        boolean falg = false;
        Integer orderId = null;
            List<OrderDetalis> orderDetalis = order.getOrderDetalis();
            falg = mapper.insertOrder(order);
            orderId = order.getOrderId();
            for(int i = 0;i<orderDetalis.size();i++){
                OrderDetalis detalis= orderDetalis.get(i);
                detalis.setOrderId(orderId);
                orderDetalisMapper.insertOrderDetali(detalis);
            }
            mapper.updateMonthlySales(order.getBusinessId());
        return falg;
    }

}
