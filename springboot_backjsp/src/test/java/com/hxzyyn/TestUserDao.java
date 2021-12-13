package com.hxzyyn;

import com.hxzyyn.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lulei
 * @date 2021年12月11日 09:58:50
 */

@SpringBootTest //明确告诉它这是一个springboot测试类
public class TestUserDao {
    @Autowired
    private UserDao userDao;

    @Test
    public void testFindAll() {
        userDao.findAll().forEach(System.out::println);
    }


    @Test
    public void testLogin() {
        System.out.println(userDao.login("admin", "admin"));
    }

    @Test
    public void testRegist() {
        try {
            userDao.regist("发春哥", "123456");
            testFindAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Regist(Srting username,String pasword)异常");
        }
    }

}
