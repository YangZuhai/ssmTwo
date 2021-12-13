package com.hxzyyn.controller;

import com.hxzyyn.entity.User;
import com.hxzyyn.service.EmpService;
import com.hxzyyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author lulei
 * @date 2021年12月11日 15:36:00
 */

@Controller
@RequestMapping("pages")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmpService empService;

    @RequestMapping("login")
    public String login() {
        return "/pages/login";
    }

    @PostMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, Model model) {
        System.out.println("啦啦啦");
        User user = null;
        try {
            user = userService.login(username, password);
            if (user == null) {
                model.addAttribute("msg", "用户名或密码错误");
                return "redirect:/pages/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("login()异常");
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return "redirect:/pages/findAll";

    }

    @RequestMapping("findAll")
    public String findAll(Model model, HttpServletRequest request) {
        try {
            model.addAttribute("empList", empService.findAllEmps());
            HttpSession session = request.getSession();
            if (session.getAttribute("user") == null) {
                return "redirect:/pages/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("findAll()异常");
        }
        System.out.println(".....");
        return "/pages/emplist";
    }

    @GetMapping("regist")
    public String regist() {
        return "/pages/regist";
    }

    @PostMapping("regist")
    public String regist(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            userService.regist(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("regist(String username,String password)异常");
        }
        return "redirect:/pages/login";

    }


}
