package org.example.dao;

import org.example.entity.Department;
import org.apache.ibatis.annotations.Param;

public interface DepartmentDAO {

    // 查询部门，及其所有员工信息
    Department queryDepartmentById(@Param("id") Integer id);
}
