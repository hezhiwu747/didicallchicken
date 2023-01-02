package com.didicallchicken.service.impl;

import com.didicallchicken.mapper.UserMapper;
import com.didicallchicken.pojo.User;
import com.didicallchicken.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private  UserMapper mapper;

    @Override
    public User login(String username, String password) {

        User user = mapper.login(username, password);
        return user;
    }

    @Override
    public boolean register(String username, String password) {
            //4. 判断用户名是否存在
            User u = mapper.selectByUsername(username);
            if(u == null){
                // 用户名不存在，注册
                mapper.register(username,password);
            }
            return u == null;

    }

    @Override
    public User selectByUsername(String username) {
        User user = mapper.selectByUsername(username);
        return user;

    }

    @Override
    public boolean updatePassword(User user) {
        boolean falg = mapper.updatePassword(user);
        return falg;
    }

    @Override
    public boolean updateName(User user) {
        boolean falg = mapper.updateName(user);
        return falg;
    }

}
