package com.didicallchicken.contorllers;


import com.didicallchicken.pojo.Business;
import com.didicallchicken.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    //查询所有商家
    @RequestMapping(value = "/business.do",params = "operate=selectAll")
    @ResponseBody
    public List<Business> selectAll() throws IOException {
        return businessService.selectAll();
    }

    /**
     * 根据用户选择的标签做查询
     * @throws IOException
     */
    @RequestMapping(value = "/business.do",params = "operate=selectByTarget")
    @ResponseBody
    public List<Business> selectByTarget(@RequestParam("target") String target) throws IOException {
        return businessService.selectBusinessByType(target);
    }

    //根据商家和商品名称搜索
    @RequestMapping(value = "/business.do",params = "operate=search")
    @ResponseBody
    public  List<Business> search(@RequestParam("name") String name) throws IOException {
        return businessService.searchBusByName(name);
    }
}
