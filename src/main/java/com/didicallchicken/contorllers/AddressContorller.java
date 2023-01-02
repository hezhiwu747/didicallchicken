package com.didicallchicken.contorllers;

import com.didicallchicken.pojo.Address;
import com.didicallchicken.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class AddressContorller {

     @Autowired
     private AddressService addressService;

     //查询用户的所有收货地址
    @RequestMapping(value = "/address.do",params = "operate=selectAddressByUser")
    @ResponseBody
    public List<Address> selectAddressByUser(@RequestBody Map map) throws IOException {
        Integer userId = (Integer)map.get("userId");
        List<Address> addresses = addressService.selectAddressByUser(userId);
        return addresses;
    }

    //修改用户地址的请求
    @RequestMapping(value = "/address.do",params = "operate=updateAddress"
    ,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String  updateAddress(@RequestBody Address address) throws IOException {
        return addressService.updateAddress(address) ? "201" : "301";
    }

    //删除用户地址
    @RequestMapping(value = "/address.do",params = "operate=deleteAddress",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String  deleteAddress(@RequestBody Address address) throws IOException {
        Integer addressId = address.getAddressId();
        return addressService.deleteById(addressId) ? "201" : "301";
    }

    //添加用户收货地址
    @RequestMapping(value = "/address.do",params = "operate=addAddress",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String  addAddress(@RequestBody Address address) throws IOException {
        return addressService.addAddress(address) ? "201" : "301";
    }

}
