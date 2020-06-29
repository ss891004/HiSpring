package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl3 implements  UserService{
    @Override
    public void add() {
        System.out.printf("注册用户并激活会员~~~~~");
    }
}
