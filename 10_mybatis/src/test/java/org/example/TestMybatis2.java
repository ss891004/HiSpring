package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.UserDAO2;
import org.example.entity.User;
import org.example.util.Util;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestMybatis2 {

    UserDAO2 mapper;
    @Before
    public void init(){
        mapper = Util.getMapper(UserDAO2.class);
    }

    @Test
    public void test1(){
        List<User> users = mapper.queryUsers();
        System.out.println("================");
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void test2(){
        User user = new User();
        //user.setId(3);
        user.setUsername("xxxx");
        User user1 = mapper.queryUser(user);
        System.out.println(user1);
    }

    @Test
    public void test3(){
        User user  = new User();
        //user.setUsername("shine_0");
        user.setGender(true);
        List<User> users = mapper.queryUser2(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void test4(){
        User user = new User(6,"shine_0002","9876543210",true,null);
        mapper.updateUser(user);
        Util.commit();
    }

    @Test
    public void test5(){
        List<Integer> ids = Arrays.asList(2, 3);
        mapper.deleteManyUser(ids);
        Util.commit();
    }

    @Test
    public void test6(){
        List<User> users = Arrays.asList(
                new User(null, "张三", "123", true, new Date()),
                new User(null, "李四", "456", false, new Date()));
        mapper.insertManyUser(users);
        Util.commit();
    }

    @Test
    public void test7(){
        SqlSession sqlSession = Util.openSession();
        UserDAO2 mapper = sqlSession.getMapper(UserDAO2.class);
        List<User> users = mapper.queryUsers();
        System.out.println("===========");
        List<User> users1 = mapper.queryUsers();

        System.out.println("-------------------------------");
        SqlSession session = Util.getSession();
        UserDAO2 mapper1 = session.getMapper(UserDAO2.class);
        mapper1.queryUsers();
    }

    @Test
    public void test8(){
        // 通过相同的SqlSessionFactory获取多个SqlSession
        SqlSession session1 = Util.getSession();
        SqlSession session2 = Util.getSession();
        SqlSession session3 = Util.getSession();
        UserDAO2 mapper1 = session1.getMapper(UserDAO2.class);
        UserDAO2 mapper2 = session2.getMapper(UserDAO2.class);
        UserDAO2 mapper3 = session3.getMapper(UserDAO2.class);
        mapper1.queryUsers();
        session1.close(); //二级缓存生效

        //修改   ，修改相关的缓存，会被移除
        SqlSession session4 = Util.getSession();
        UserDAO2 mapper4 = session4.getMapper(UserDAO2.class);
        mapper4.deleteUser(10010);
        session4.commit();
        session4.close();

        System.out.println("===================");
        mapper2.queryUsers();
        session2.close();
        System.out.println("===================");
        mapper3.queryUsers();
        session3.close();
    }
    /*
    @Test
    public void testPage(){
        UserDAO2 mapper = Util.getMapper(UserDAO2.class);
        //在查询前，设置分页  查询第一页，每页2条数据
        // PageHelper 对其之后的第一个查询，进行分页功能追加
        PageHelper.startPage(2,2);
        List<User> users = mapper.queryUsers();
        for (User user : users) {
            System.out.println(user);
        }
        // 将查询结果 封装到 PageInfo对象中
        PageInfo<User> pageInfo = new PageInfo(users);
        System.out.println("================");
    }
     */

}
