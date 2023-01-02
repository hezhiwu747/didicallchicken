package com.didicallchicken.mapper;


import com.didicallchicken.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */

    User login(@Param("username") String username, @Param("password") String password);

    /**
     * 注册
     * @param username
     * @param password
     */
    boolean register(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    @Select("SELECT * FROM tb_user WHERE username=#{username}")
    @ResultMap("resultMapUser")
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
