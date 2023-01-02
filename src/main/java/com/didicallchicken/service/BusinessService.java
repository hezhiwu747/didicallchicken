package com.didicallchicken.service;

import com.didicallchicken.pojo.Business;

import java.util.List;

public interface BusinessService {

    //查询所有商家
    List<Business> selectAll();

    /**
     * 根据标签返回符合类型的商家列表
     * @param type
     * @return
     */
    List<Business> selectBusinessByType(String type);

    /**
     * 搜索
     * @param name
     * @return
     */
    List<Business> searchBusByName(String name);
}
