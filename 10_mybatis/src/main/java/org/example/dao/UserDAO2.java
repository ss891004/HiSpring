package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.User;

import java.util.List;

public interface UserDAO2 {

    List<User> queryUsers();
    //返回单个对象
    User queryUserById(@Param("id") Integer id);
    User queryUserByUsername(@Param("username") String username);
    User queryUser(User user);

    List<User>  queryUser2(User user);

    Integer deleteUser(@Param("id") Integer id);
    Integer updateUser(User user);
    Integer insertUser(User user);

    Integer deleteManyUser(List<Integer> ids);
    Integer insertManyUser(List<User> users);
}
