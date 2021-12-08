package com.hxzyyn.dao;

import com.hxzyyn.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author lulei
 * @date 2021年12月07日 10:07:03
 */
public interface UserDao {
    /**
     * 用户登录
     * @param
     * @param
     * @return
     */
    User login(@Param("username")String username,@Param("password") String password );

    /**
     * 用户注册
     * @param user
     * @return
     */
    int save(User user);
}
