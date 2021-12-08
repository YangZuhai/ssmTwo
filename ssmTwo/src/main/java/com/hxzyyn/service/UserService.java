package com.hxzyyn.service;

import com.hxzyyn.entity.User;

/**
 * @author lulei
 * @date 2021年12月07日 10:12:11
 */
public interface UserService {

    User login(String username, String password);

    int save(User user);

}
