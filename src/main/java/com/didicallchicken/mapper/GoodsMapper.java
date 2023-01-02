package com.didicallchicken.mapper;

import com.didicallchicken.pojo.Goods;

import java.util.List;

public interface GoodsMapper {

    /**
     * 当用户点击一个具体的商家之后，将获取到的商家id传入当方法参数放回一个商品列表
     * @param businessId
     * @return
     */
    List<Goods> selectByBusinessId(int businessId);

    /**
     *获取单条商品记录
     * @param goodsId
     * @return
     */
    Goods selectAllByGoodsId(int goodsId);

}
