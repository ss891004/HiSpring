package org.example.dao;

import org.example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDAO {

    //查询，几种不同的参数
    //序号参数绑定
    User queryUserById(Integer id);
    User queryUserByIdAndUsername(Integer id, String username);

    //注解参数绑定
    User queryUserByIdAndPassword(@Param("id") Integer id, @Param("password") String password);
    //Map参数绑定
    User queryUserByIdAndPassword2(Map map);
    //对象属性参数绑定
    User queryUserByIdAndPassword3(User user);
    //模糊查询
    List<User> queryUserByUsername(@Param("username") String username);

    Integer deleteUser(@Param("id") Integer id);

    Integer updateUser(User user);

    Integer insertUser(User user);

}
