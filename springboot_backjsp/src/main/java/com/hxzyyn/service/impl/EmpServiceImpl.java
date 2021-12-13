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
 * @date 2021年12月11日 18:25:42
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;


    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public List<Emp> findAllEmps() {
        return empDao.findAllEmps();
    }

    @Override
    public void save(Emp emp) {
        empDao.save(emp);
    }
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public Emp findEmpByWhere(Emp emp) {
        return empDao.findEmpByWhere(emp);
    }

    @Override
    public void updateEmp(Emp emp) {
        empDao.updateEmp(emp);
    }

    @Override
    public void deleteEmp(int id) {
        empDao.deleteEmp(id);
    }
}
