package com.springboot.entity;

import javax.persistence.*;

/**
 * @ project  项目介绍
 * @ author  clsr
 * @ date  2019/3/8
 */
@Entity(name = "tbl_dept")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer deptId;
    @Column
    private String deptName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
