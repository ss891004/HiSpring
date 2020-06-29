package service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AppConfig;
import service.UserService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {
    @Autowired
    private UserService us;

    @Autowired
    //使用限定符
    @Qualifier("us1")
    private UserService us1;

    @Autowired
    @Qualifier("usi2")
    private UserService us2;

    @Autowired
    @Qualifier("userServiceImpl3")
    private UserService us3;

    @Test
    public void test0() {
        us.add();
    }

    @Test
    public void test2() {
        us1.add();
    }

    @Test
    public void test3() {
        us2.add();
    }

    @Test
    public void test4() {
        us3.add();
    }
}
