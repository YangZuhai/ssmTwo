package com.hxzyyn.dao;

import com.hxzyyn.entity.Emp;

import java.util.List;

/**
 * @author lulei
 * @date 2021年12月11日 16:41:43
 */
public interface EmpDao {
    /**
     * 查询全部数据
     * @return
     */
    List<Emp> findAllEmps();

    /**
     * 增加数据
     * @param emp
     */
    void save(Emp emp);

    /**
     * 查询单条
     * @param emp
     * @return
     */
    Emp findEmpByWhere(Emp emp);

    /**
     * 更新数据
     * @param emp
     */
    void updateEmp(Emp emp);

    /**
     * 删除数据
     * @param id
     */
    void deleteEmp(int id);





}
