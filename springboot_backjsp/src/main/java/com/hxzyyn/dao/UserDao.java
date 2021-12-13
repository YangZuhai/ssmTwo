package com.hxzyyn.dao;

import com.hxzyyn.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lulei
 * @date 2021年12月11日 09:51:00
 */
public interface UserDao {
    /**
     * 用户登录
     * @param username
     * @param password
     */
    User login(@Param("username")String username, @Param("password")String password);

    void regist(@Param("username")String username,@Param("password")String password);

    List<User> findAll();
}
