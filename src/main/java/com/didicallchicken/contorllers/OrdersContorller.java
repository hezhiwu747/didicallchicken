package com.didicallchicken.contorllers;

import com.didicallchicken.pojo.FullOrdersRepresentation;
import com.didicallchicken.pojo.OrderDetalis;
import com.didicallchicken.pojo.OrderInformationDisplay;
import com.didicallchicken.pojo.Orders;
import com.didicallchicken.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class OrdersContorller {

    @Autowired
    private OrdersService ordersService;

    //查看当前用户的所有订单
    @RequestMapping(value = "/orders.do",params = "operate=selectAll")
    @ResponseBody
    public  List<FullOrdersRepresentation>  selectAll(@RequestBody Map map) throws IOException {
        Integer userId = (Integer) map.get("userId");
        List<FullOrdersRepresentation> orders = ordersService.selectAll(userId);
        return orders;
    }

    //查看单条订单？
    @RequestMapping(value = "/orders.do",params = "operate=selectByOrder",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public OrderInformationDisplay selectByOrder(@RequestBody Orders order) throws IOException {
        Integer orderId = order.getOrderId();
        OrderInformationDisplay ordersInfo = ordersService.selectByOrderId(orderId);
        return ordersInfo;
    }

    /**
     * 购买
     */
    @RequestMapping(value = "/orders.do",params = "operate=buy",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String  buy(@RequestBody Orders<OrderDetalis> order) throws IOException {
//        boolean falg = ordersService.insertOrder(order);
//        if (falg) {
//           return "201";
//        }
//        return "301";
        return  ordersService.insertOrder(order) ? "201" : "301";

    }

}
