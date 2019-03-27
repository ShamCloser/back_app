package com.springboot.service.serviceImp;

import com.springboot.entity.Department;
import com.springboot.repository.DeptRepository;
import com.springboot.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @ project  项目介绍
 * @ author  clsr
 * @ date  2019/3/26
 */
@Service
public class DeptServiceImp implements IDeptService {
    @Autowired
    DeptRepository deptRepository;

    @Override
    public Collection<Department> allDepartment() {
        return deptRepository.findAll();
    }

    @Override
    public Department findDeptByDeptId(Integer deptId) {
        return deptRepository.findDepartmentByDeptId(deptId);
    }
}
