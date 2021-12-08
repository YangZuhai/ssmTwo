package com.hxzyyn.controller;

import com.hxzyyn.entity.Emp;
import com.hxzyyn.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lulei
 * @date 2021年12月08日 09:12:41
 */
@Controller
@RequestMapping("emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("addEmp")
    public String addEmp() {
        return "/pages/addEmp";
    }

    @PostMapping("addEmp")
    public String addEmp(Emp emp) {
        System.out.println(emp);
        try {
            empService.save(emp);
            System.out.println("添加数据成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/user/empFindAll";
    }

    @GetMapping("updateEmp")
    public String updateEmp(int id, Model model) {
        System.out.println(id);
        model.addAttribute("emp", empService.getEmpById(id));
        return "/pages/updateEmp";
    }

    @PostMapping("updateEmp")
    public String updateEmp(Emp emp) {
        try {
            empService.update(emp);
            System.out.println("修改数据成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/user/empFindAll";
    }

    @GetMapping("delete")
    public String delete(int id) {
        try {
            empService.delete(id);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("/emp/delete(int id) 异常");
        }

        return "redirect:/user/empFindAll";
    }


}
