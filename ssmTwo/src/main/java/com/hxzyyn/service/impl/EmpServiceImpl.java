package com.hxzyyn.service.impl;

import com.hxzyyn.dao.EmpDao;
import com.hxzyyn.entity.Emp;
import com.hxzyyn.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lulei
 * @date 2021年12月07日 10:51:44
 * @Transactional(rollbackFor = Exception.class) 增删改时必须加
 * @Service 告诉他这个一个Service的组建 相当于bin标签下的class指向实现全限定名
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmpServiceImpl implements EmpService {

    @Autowired  //自动注入 根据类型
    private EmpDao empDao;

    /**
     * @return
     * @Transactional(propagation = Propagation.SUPPORTS,rollbackFor=Exception.class) 查询时加上
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<Emp> finaAll() {
        return empDao.findAll();
    }

    @Override
    public void save(Emp emp) {
        empDao.save(emp);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public Emp getEmpById(int id) {
        return empDao.getEmpById(id);
    }

    @Override
    public void update(Emp emp) {
        empDao.update(emp);
    }

    @Override
    public void delete(int id) {
        empDao.delete(id);
    }



}
