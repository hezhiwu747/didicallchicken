package com.didicallchicken.contorllers;

import com.alibaba.fastjson.JSON;
import com.didicallchicken.pojo.User;
import com.didicallchicken.service.UserService;
import com.didicallchicken.util.CheckCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserContorller{

        @Autowired
        private UserService userService;
        //登录
        @RequestMapping(value = "/user.do",params = "operate=login",produces = {"application/json;charset=utf-8"})
        @ResponseBody
        public String  login(@RequestBody User user)throws Exception{
            String username = user.getUsername();
            String password = user.getPassword();
            //1. 获取用户名和密码数据
            User login = userService.selectByUsername(username);
            if(login != null) {
                    login = userService.login(username, password);
                if (login != null) {
                    //登录成功
                    String jsonStr = JSON.toJSONString(login);
                    return jsonStr;
                }else {
                    //密码错误
                    return "wrong password";
                }
            }
            //账号不存在
           return "account does not exist";
        }

        //注册
        @RequestMapping(value = "/user.do",params = "operate=register",produces = {"application/json;charset=utf-8"})
        @ResponseBody
        public String  register(@RequestParam("checkCode") String checkCode,
                                @RequestBody User user,HttpSession session) throws IOException {
            String username = user.getUsername();
            String password = user.getPassword();
            // 程序生成的验证码，从Session获取
            String checkCodeGen = (String) session.getAttribute("checkCodeGen");
            // 比对
            if(!checkCodeGen.equalsIgnoreCase(checkCode)){
                //验证码不正确,不允许注册
                return "wrong checkCode";
                }
            boolean falg = userService.register(username, password);
            if(falg){
                //注册成功
               return "register scuess";
            }else {
                //账号已被注册
               return "account already exist";
            }
        }

        //获取验证码的参数
        @RequestMapping(value = "/user.do")
        @ResponseBody
        public void checkCode(HttpSession session, HttpServletResponse response) throws IOException {
            // 生成验证码
            ServletOutputStream os = response.getOutputStream();
            String checkCode = CheckCodeUtil.outputVerifyImage(300, 50, os, 4);
            // 存入Session
            session.setAttribute("checkCodeGen",checkCode);
        }

        //用户修改密码
        @RequestMapping(value = "/user.do",params = "operate=updatePassword",produces = {"application/json;charset=utf-8"})
        @ResponseBody
        public String  updatePassword(@RequestBody User user) throws IOException {
            //用户修改密码成功的标识
            //响应201代表修改昵称成功了
            return userService.updatePassword(user) ? "201" : "301";

        }
        //修改用户昵称
        @RequestMapping(value = "/user.do",params = "operate=updateName",produces = {"application/json;charset=utf-8"})
        @ResponseBody
        public String  updateName(@RequestBody User user) throws IOException {
            //用户修改密码成功的标识
             //响应201代表修改昵称成功了
            return userService.updateName(user) ? "201" : "301";
        }


}
