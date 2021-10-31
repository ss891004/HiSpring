package hm.service;

import hm.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        System.out.println("UserServiceImpl-UserDaoConstructor");
    }

    public UserServiceImpl() {
        System.out.println("UserServiceImpl-NoneConstructor");
    }

    @Override
    public void addUser() {
        userDao.addUser();
        System.out.println("UserServiceImpl-addUser");
    }
}
