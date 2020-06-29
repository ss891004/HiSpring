package service;

import org.springframework.stereotype.Component;

@Component("usi2")
public class UserServiceImpl2  implements  UserService{
    @Override
    public void add() {
        System.out.printf("注册用户并发送优惠券");
    }
}
