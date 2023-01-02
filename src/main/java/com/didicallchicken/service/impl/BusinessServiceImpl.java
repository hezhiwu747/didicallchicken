package com.didicallchicken.service.impl;

import com.didicallchicken.mapper.BusinessMapper;
import com.didicallchicken.pojo.Business;
import com.didicallchicken.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BusinessServiceImpl implements BusinessService {


    @Autowired
    private BusinessMapper mapper;

    @Override
    public List<Business> selectAll() {

        List<Business> businesses = mapper.selectAll();

        return businesses;
    }

    @Override
    public List<Business> selectBusinessByType(String type) {
        List<Business> businesses = mapper.selectBusinessByType(type);
        return businesses;
    }

    @Override
    public List<Business> searchBusByName(String name) {
        name = "%"+name+"%";
        List<Business> businesses = mapper.searchBusByName(name);
        return businesses;
    }
}
