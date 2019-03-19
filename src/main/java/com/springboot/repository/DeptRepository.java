package com.springboot.repository;

import com.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ project  项目介绍
 * @ author  clsr
 * @ date  2019/3/15
 */
public interface DeptRepository extends JpaRepository<Department,Integer> {
    Department findDepartmentByDeptId(Integer deptId);
}
