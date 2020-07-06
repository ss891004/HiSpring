package org.example.dao;

import org.example.entity.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeDAO {

    // 查询员工信息 并且 查到对应的部门信息
    Employee queryEmployeeById(@Param("id") Integer id);
}
