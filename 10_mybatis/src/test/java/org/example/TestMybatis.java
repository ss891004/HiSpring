package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.*;
import org.example.entity.*;
import org.example.util.Util;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {


    @Test
    public void test3() {
        PassengerDAO mapper = Util.getMapper(PassengerDAO.class);
        Passenger passenger = mapper.queryPassengerById(1);
        System.out.println("============");
        System.out.println(passenger);
        System.out.println(passenger.getPassport());

        PassportDAO mapper1 = Util.getMapper(PassportDAO.class);
        Passport passport = mapper1.queryPassportById(1);
        System.out.println(passport);
        System.out.println(passport.getPassenger());

        DepartmentDAO mapper2 = Util.getMapper(DepartmentDAO.class);
        Department department = mapper2.queryDepartmentById(2);
        System.out.println(department);
        List<Employee> employees = department.getEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        EmployeeDAO mapper3 = Util.getMapper(EmployeeDAO.class);
        Employee employee = mapper3.queryEmployeeById(2);
        System.out.println(employee);
        System.out.println(employee.getDepartment());
    }


    @Test
    public void test2() {

//        StudentDAO studentMapper = Util.getMapper(StudentDAO.class);
//        Student student = new Student(null, "test_util", true);
//        studentMapper.insertStudent(student);
//        Util.commit();

        UserDAO userMapper = Util.getMapper(UserDAO.class);
        User user = userMapper.queryUserById(2);
        System.out.println(user);

        UserDAO userMapper2 = Util.getMapper(UserDAO.class);
        Map map = new HashMap();
        map.put("id",3);
        map.put("password","00000");
        User user2 = userMapper2.queryUserByIdAndPassword2(map);
        System.out.println(user2);
    }

    /**
     * 使用mybatis 的步骤
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        // MyBatis API
        // 1. 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 2. 构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3. 通过SqlSessionFactory 创建 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //4. 通过SqlSession 获得 DAO实现类的对象
            UserDAO mapper = sqlSession.getMapper(UserDAO.class);//获取UserDAO对应的实现类的对象


            //新增用户
            User new_user = new User(null, "xxxx", "00000", true, new Date());
            int iii = mapper.insertUser(new_user);

            System.out.println(new_user);
            System.out.println(iii);

            if (iii > 0) {
                //5.提交事务
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }

            //学生增加
            StudentDAO studentMapper = sqlSession.getMapper(StudentDAO.class);
            Student student = new Student(null, "shine_001", true);
            studentMapper.insertStudent(student);
            System.out.println(student);

            //5.提交事务
            sqlSession.commit();
            //sqlSession.rollback();


        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            //6. 资源释放
            sqlSession.close();
        }
    }
}
