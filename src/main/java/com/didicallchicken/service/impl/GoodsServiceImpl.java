package com.didicallchicken.service.impl;

import com.didicallchicken.mapper.GoodsMapper;
import com.didicallchicken.pojo.Goods;
import com.didicallchicken.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
   private GoodsMapper mapper;

    @Override
    public List<Goods> selectByBusinessId(int businessId) {
        List<Goods> goods = mapper.selectByBusinessId(businessId);
        return goods;
    }

    @Override
    public Goods selectAllByGoodsId(int goodsId) {
        Goods goods = mapper.selectAllByGoodsId(goodsId);
        return goods;
    }
}
