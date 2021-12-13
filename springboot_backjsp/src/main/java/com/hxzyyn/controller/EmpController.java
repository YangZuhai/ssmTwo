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
 * @date 2021年12月11日 19:57:10
 */

@Controller
@RequestMapping("pages")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("addEmps")
    public String addEmps() {
        return "/pages/addEmp";
    }

    @PostMapping("addEmps")
    public String addEmps(Emp emp) {
        try {
            empService.save(emp);
            System.out.println("成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("addEmps()异常");
        }
        return "redirect:/pages/findAll";
    }

    @RequestMapping("update")
    public String update(int id, Model model) {

        try {
            Emp emp = new Emp();
            emp.setId(id);
            Emp emps = empService.findEmpByWhere(emp);
            model.addAttribute("emps", emps);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("update(int id)异常");
        }

        return "/pages/updateEmp";
    }

    @PostMapping("update")
    public String update(Emp emp) {
        try {
            empService.updateEmp(emp);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("update(Emp emp) 异常");
        }

        return "redirect:/pages/findAll";
    }

    @GetMapping("delete")
    public String delete(int id) {
        try {
            empService.deleteEmp(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("delete(int id)异常");
        }
        return "redirect:/pages/findAll";

    }


}
