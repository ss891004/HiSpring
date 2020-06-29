package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("us1")
public class UserServiceImpl1 implements UserService {
    @Override
    public void add() {
        System.out.println("添加用户~~~~~~~");
    }
}
