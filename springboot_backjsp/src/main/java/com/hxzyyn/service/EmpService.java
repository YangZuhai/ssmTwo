package com.hxzyyn.service;

import com.hxzyyn.entity.Emp;

import java.util.List;

/**
 * @author lulei
 * @date 2021年12月11日 17:42:35
 */
public interface EmpService {

    List<Emp> findAllEmps();

    void save(Emp emp);

    Emp findEmpByWhere(Emp emp);

    void updateEmp(Emp emp);

    void deleteEmp(int id);
}
