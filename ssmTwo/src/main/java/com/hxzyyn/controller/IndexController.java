package com.hxzyyn.controller;


import com.hxzyyn.entity.User;
import com.hxzyyn.service.UserService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.UUID;

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

        return "/pages/login";
    }

    @GetMapping("regist")
    public String regist() {

        return "/pages/regist";
    }

//    注册
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

    @GetMapping("upload")
    public String upload() {
        return "/pages/upload";
    }

    @PostMapping("upload")
//    MultipartFile 储存name为img 的按钮
    public String upload(MultipartFile[] img, HttpServletRequest request) {

        for (int i = 0; i < img.length; i++) {
            if(img[i].getOriginalFilename()!=null&&!"".equals(img[i].getOriginalFilename())){
                System.out.println("文件名:" + img[i].getOriginalFilename());
                System.out.println("文件大小:" + img[i].getSize() + "字节");
                System.out.println("文件上传类型:" + img[i].getContentType());
            }
//       文件上传
//        1.根据 upload相对路径获取到部署到服务器之后的绝对路径
            String realPath = null;
            realPath = request.getSession().getServletContext().getRealPath("/upload");
//        2.修改原文件名称
            String newFileName = null;
            if (img[i].getOriginalFilename() == null || "".equals(img[i].getOriginalFilename() )) {
                continue;
            }
            if (img[i].getOriginalFilename()  != null || !"".equals(img[i].getOriginalFilename() )) {
                String extension = FilenameUtils.getExtension(img[i].getOriginalFilename());
                newFileName = UUID.randomUUID().toString().replace("-", "") + "." + extension;
            }
//        3.生成当天日期目录
            try {
                LocalDate now = LocalDate.now();
                File dataDir = new File(realPath, now.toString());
//文件夹不存在,创建
                if (!dataDir.exists()) {
                    dataDir.mkdirs();
                }
                //        4.将文件上传到upload文件夹对应日期目录中
                if (img[i].getOriginalFilename()  == null || "".equals(img[i].getOriginalFilename() )) {
                    continue;
                } else {
                    img[i].transferTo(new File(dataDir, newFileName));
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("上传第"+(i+1)+"张名为:" + img[i].getOriginalFilename()  + "名的图片异常");
            }
        }
        return "redirect:/pages/upload";
    }

    /**
     * 文件打开/下载
     *
     * @param fileName
     * @param request
     * @param response
     */
    @RequestMapping("download")
//    name名为fileName
//   openStyle 标识
    public void download(String openStyle, String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        System.out.println("下载文件的名称:" + fileName);
//        字符串变量 存标识 判断在线代开还是附件下载
//        三元三目表达式 类似if-else
        openStyle = openStyle == null ? "inline" : "attachment";
//        1.根据下载相对目录获取下载在服务器部署之后的绝对目录
        String realPath = request.getSession().getServletContext().getRealPath("/file");
//        2.通过文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath, fileName));
//        3.获取响应输出流
        response.setContentType("text/plain;charset=UTF-8");
//        4.附件下载(inline代表在线打开,attachment代表下载文件)
        response.setHeader("content-disposition", openStyle + ";fileName=" + URLEncoder.encode(fileName, "UTF-8"));
//        5.处理下载流复制
        ServletOutputStream os = response.getOutputStream();
//        6.使用springMVC工具类
        IOUtils.copy(is, os);
//        优雅关闭
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }





}
