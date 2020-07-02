package org.example;

import org.example.dao.UserDao;
import org.example.service.UserService;
import org.example.web.UserController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("org.example")
//@ComponentScan(basePackages = {"org.example.web","org.example.dao","org.example.service"})
@ComponentScan(basePackageClasses = {UserDao.class, UserService.class, UserController.class})
public class AppConfig {

    //设置组件扫描的基础包
}
