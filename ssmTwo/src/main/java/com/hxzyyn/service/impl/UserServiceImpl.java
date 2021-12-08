package com.hxzyyn.service.impl;

import com.hxzyyn.dao.EmpDao;
import com.hxzyyn.dao.UserDao;
import com.hxzyyn.entity.User;
import com.hxzyyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author lulei
 * @date 2021年12月07日 10:12:56
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public int save(User user) {
        return userDao.save(user);
    }
}
