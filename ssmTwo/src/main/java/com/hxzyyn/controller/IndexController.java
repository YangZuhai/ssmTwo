package com.hxzyyn.controller;


import com.hxzyyn.entity.User;
import com.hxzyyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lulei
 * @date 2021年12月04日 16:25:31
 */
@Controller
@RequestMapping("pages")
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login() {

        return "pages/login";
    }

    @GetMapping("regist")
    public String regist() {

        return "/pages/regist";
    }

    @PostMapping("regist")
    public String rigist(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            int flag=userService.save(user);
            if(flag==1){
                System.out.println("成功");
            }else{
                System.out.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("rigist(String username,String password)异常");
        }

        return "redirect:/pages/login";
    }

//    @GetMapping("upload")
//    public String upload() {
//        return "pages/upload";
//    }
//
//    @PostMapping("upload")
//    public String upload(MultipartFile img, HttpServletRequest request) {
//        System.out.println("文件名:" + img.getOriginalFilename());
//        System.out.println("文件大小:" + img.getSize() + "字节");
//        System.out.println("文件上传类型:" + img.getContentType());
//
////       文件上传
////        1.根据 upload相对路径获取到部署到服务器之后的绝对路径
//        request.getSession().getServletContext().getRealPath("/upload");
////        2.修改源文件名称
//        String extension = FilenameUtils.getExtension(img.getOriginalFilename());
////        3.生成当天日期目录
//
////        4.将文件上传到upload文件夹对应日期目录中
//
//        return null;
//    }

}
