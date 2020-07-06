package org.example.dao;

import org.example.entity.Subject;
import org.apache.ibatis.annotations.Param;

public interface SubjectDAO {

    Subject querySubjectById(@Param("id") Integer id);
}
