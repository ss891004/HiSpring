package org.example.config;

import org.example.dao.UserDao;
import org.example.dao.UserDaoCache;
import org.example.dao.UserDaoFile;
import org.example.dao.UserDaoNormal;
import org.example.service.UserService;
import org.example.service.UserServiceNormal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 装配的歧义性
 * 方法一 @Primary
 * 方法二 @Bean("a2")
 * 方法三 @Qualifier("a2")
 */
@Configuration
public class AppConfig {

    @Bean
    @Primary
    public UserDao abcde() {
        System.out.println("开始生产UserDaoNormal对象");
        //创建对象
        return new UserDaoNormal();
    }

    @Bean("a2")
    public UserDao abcde1() {
        System.out.println("开始生产UserDaoCache对象");
        //创建对象
        return new UserDaoCache();
    }

    @Bean
    @Qualifier("a2")
    public UserDao abcde2() {
        System.out.println("开始生产UserDaoCache对象");
        //创建对象
        return new UserDaoFile();
    }


    @Bean("a3")
    public UserService bcdef() {
        System.out.println("开始生产UserServiceNormal对象");
        //说明Bean对象是单例的， 在调用abcde方法时，Spring回检查容器中是否已经创建对象，若有，直接使用，不在新建。
        //通过构造函数依赖注入
        return new UserServiceNormal(abcde());

    }

    @Bean
    @Primary
    public UserService bcdef1(@Qualifier("a2") UserDao userDao) {
        System.out.println("开始生产UserServiceNormal对象");

        //通过setter方法依赖注入
        UserServiceNormal usn = new UserServiceNormal();
        usn.setUserDao(userDao);
        return usn;

    }

}
