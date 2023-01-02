package com.didicallchicken.mapper;

import com.didicallchicken.pojo.Address;

import java.util.List;

public interface AddressMapper {

    /**
     * 用户添加收货地址
     * @param address
     */
    boolean addAddress(Address address);

    /**
     * 用户修改收货地址
     * @param address
     */
    boolean updateAddress(Address address);

    /**
     * 用户删除收货地址
     */
    boolean deleteById(int addressId);

    /**
     * 根据当前用户查询所有收货地址
     * @param userId
     * @return
     */
    List<Address> selectAddressByUser(int userId);

    /**
     * 根据地址id查询
     * @param addressId
     * @return
     */
    Address searchAddressId(int addressId);

}
