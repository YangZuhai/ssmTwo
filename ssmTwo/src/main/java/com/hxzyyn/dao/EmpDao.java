package com.hxzyyn.dao;

import com.hxzyyn.entity.Emp;

import java.util.List;

/**
 * @author lulei
 * @date 2021年12月07日 10:47:39
 */
public interface EmpDao {

    List<Emp> findAll();

    /**
     * 添加员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 根据id查询单条数据
     * @param id
     * @return
     */
    Emp getEmpById(int id);

    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);

    void delete(int id);
}
