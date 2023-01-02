package com.didicallchicken.contorllers;

import com.didicallchicken.pojo.Business;
import com.didicallchicken.pojo.Goods;
import com.didicallchicken.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class GoodsContorller {

    @Autowired
    private GoodsService goodsService;

    /**
     * 根据当前用户点击的商家查询对应的所有商品
     */
    @RequestMapping(value = "/goods.do",params = "operate=selectAllByBusiness",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public  List<Goods> selectAllByBusiness(@RequestBody Business business) throws IOException {
            Integer businessId=business.getBusinessId();
            List<Goods> goodsList = goodsService.selectByBusinessId(businessId);
            return goodsList;
    }

    //查看单个商品？？？？？？？
    @RequestMapping(value = "/goods.do",params = "operate=selectGoods")
    @ResponseBody
    public Goods selectGoods(Integer goodsId) throws IOException {
            Goods goods = goodsService.selectAllByGoodsId(goodsId);
            return goods;
    }
}
