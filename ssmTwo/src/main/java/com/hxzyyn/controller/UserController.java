package com.hxzyyn.controller;

import com.hxzyyn.dao.EmpDao;
import com.hxzyyn.entity.Emp;
import com.hxzyyn.entity.User;
import com.hxzyyn.service.EmpService;
import com.hxzyyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lulei
 * @date 2021年12月07日 09:57:54
 */
@RequestMapping("user")
@Controller
@Service
public class UserController {

    @Autowired  //相当于一个xml配置文件
    private UserService userService;

    @Autowired
    private EmpService empService;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return Model 相当于request对象
     */
    @PostMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model,HttpServletRequest request) {
//        System.out.println(username+pwd);
        User user = userService.login(username, password);
        if (user == null) {
            model.addAttribute("msg", "用户名或密码错误");
            return "redirect:/pages/login";
        }
        HttpSession session=request.getSession();
        session.setAttribute("user",user);
        return "redirect:/user/empFindAll";

    }

    @GetMapping("empFindAll")
    public String empFindAll(Model model){
        List<Emp> list = empService.finaAll();
        model.addAttribute("empList", list);

        //         登录成功
//        调用查询所有员工列表
        return  "/pages/emplist";
    }
}
