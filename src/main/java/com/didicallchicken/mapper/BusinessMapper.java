package com.didicallchicken.mapper;

import com.didicallchicken.pojo.Business;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BusinessMapper {

    /**
     * 查询所有商家数据
     * @return
     */
    @Select("select * from business")
    @ResultMap("resultMapBusiness")
    List<Business> selectAll();

    /**
     * 根据标签返回符合类型的商家列表
     * @param types
     * @return
     */
    List<Business> selectBusinessByType(String types);

    /**
     * 搜索
     * @param name
     * @return
     */
    List<Business> searchBusByName(String name);
}
