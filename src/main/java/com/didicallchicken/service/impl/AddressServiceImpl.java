package com.didicallchicken.service.impl;

import com.didicallchicken.mapper.AddressMapper;
import com.didicallchicken.pojo.Address;
import com.didicallchicken.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper mapper;

    /**
     * 添加一条收货地址
     * @param address
     */
    @Override
    public boolean addAddress(Address address) {
        boolean falg = mapper.addAddress(address);
        return falg;
    }

    /**
     * 修改收货地址
     * @param address
     */
    @Override
    public boolean updateAddress(Address address) {
        boolean falg = mapper.updateAddress(address);
        return falg;
    }


    /**
     * 删除收货地址
     * @param addressId
     */
    @Override
    public boolean deleteById(int addressId) {
        boolean falg = mapper.deleteById(addressId);
        return falg;
    }

    /**
     * 查看所有收货地址
     * @param userId
     * @return
     */
    @Override
    public List<Address> selectAddressByUser(int userId) {
        List<Address> addresses = mapper.selectAddressByUser(userId);
        return addresses;
    }

    @Override
    public Address searchAddressId(int addressId) {
        Address address = mapper.searchAddressId(addressId);
        return address;
    }
}
