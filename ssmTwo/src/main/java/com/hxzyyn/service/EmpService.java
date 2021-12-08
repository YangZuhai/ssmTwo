package com.hxzyyn.service;

import com.hxzyyn.entity.Emp;

import java.util.List;

/**
 * @author lulei
 * @date 2021年12月07日 10:48:16
 */
public interface EmpService {

    List<Emp> finaAll();

    void save(Emp emp);

    Emp getEmpById(int id);

    void update(Emp emp);

    void delete(int id);

}
