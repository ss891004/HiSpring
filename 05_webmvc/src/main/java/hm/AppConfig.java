package hm;

import hm.dao.UserDao;
import hm.web.UserController;
import hm.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("org.example")
//@ComponentScan(basePackages = {"org.example.web","org.example.dao","org.example.service"})
@ComponentScan(basePackageClasses = {UserDao.class, UserService.class, UserController.class})
public class AppConfig {

    //设置组件扫描的基础包
}
