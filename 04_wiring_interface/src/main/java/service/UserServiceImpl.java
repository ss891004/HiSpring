package service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//首选bean
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加用户-UserServiceImpl");
    }
}
