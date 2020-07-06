package org.example.dao;

import org.example.entity.Passport;
import org.apache.ibatis.annotations.Param;

public interface PassportDAO {


    Passport queryPassportById(@Param("id") Integer id);
}
