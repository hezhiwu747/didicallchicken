package com.didicallchicken.service;

import com.didicallchicken.pojo.User;

public interface UserService {
    User login(String username,String password);
    boolean register(String username,String password);
    User selectByUsername(String username);
    /**
     * 修改密码
     * @param user
     * @return
     */
    boolean updatePassword(User user);

    /**
     * 修改用户昵称
     * @param user
     * @return
     */
    boolean updateName(User user);
}
