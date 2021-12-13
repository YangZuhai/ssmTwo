package com.hxzyyn.service;

import com.hxzyyn.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lulei
 * @date 2021年12月11日 10:12:10
 */
public interface UserService {

    User login(String username, String password);

    List<User> findAll();

    void regist(String username, String password);
}
