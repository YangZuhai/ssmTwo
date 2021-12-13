package com.hxzyyn;

import com.hxzyyn.dao.EmpDao;
import com.hxzyyn.dao.UserDao;
import com.hxzyyn.entity.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Scanner;

/**
 * @author lulei
 * @date 2021年12月11日 17:29:12
 */

@SpringBootTest
public class TestEmpDao {

    @Autowired
    private EmpDao empDao;

    @Test
    public void testEmpFindAll() {
        empDao.findAllEmps().forEach(System.out::println);
    }

    @Test
    public void testEmpSave() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = input.next();
        System.out.println("请输入年龄");
        int age = input.nextInt();
        Emp emp = new Emp(0, name, age, new Date());
        try {
            empDao.save(emp);
            System.out.println("成功");
            testEmpFindAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("save()异常");
        }
    }

    @Test
    public void testFindEmpByWhere() {
//        Emp emp = new Emp();
//        emp.setId(1);
        System.out.println(empDao.findEmpByWhere(new Emp(1, null, 500, null)));
    }

    @Test
    public void testUpdateEmp() {
        try {
            empDao.updateEmp(new Emp(1, "孙悟空", 500, new Date()));
            testEmpFindAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("updateEmp(Emp emp)异常");
        }
    }


    @Test
    public void testDeleteEmp() {
        try {
            empDao.deleteEmp(30);
            testEmpFindAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("deleteEmp(int id)异常");
        }
    }
}
