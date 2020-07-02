package org.example;

import org.example.config.AppConfig;
import org.example.dao.UserDao;
import org.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {

    @Autowired
    @Qualifier("a3")
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        userDao.addUser();
    }

    @Test
    public void test2() {
        userService.addUser();
    }
}
