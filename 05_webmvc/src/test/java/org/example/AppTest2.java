package org.example;

import org.example.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class AppTest2 {

    @Autowired
    private UserController userController;

    @Test
    public void test1() {

        //通过xml启用组件扫描
        userController.addUser();

    }


}
