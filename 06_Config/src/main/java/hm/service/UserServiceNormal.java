package hm.service;

import hm.dao.UserDao;

/**
 * 此类不能被扫描，不能加@Component
 */
public class UserServiceNormal implements UserService {

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
        System.out.println("UserServiceNormal-setUserDao");
    }

    private UserDao userDao;

    public UserServiceNormal() {
        System.out.println("UserServiceNormal-NoneConstructor");
    }

    public UserServiceNormal(UserDao userDao) {
        this.userDao = userDao;
        System.out.println("UserServiceNormal-UserDaoConstructor");
    }

    @Override
    public void addUser() {
        userDao.addUser();
        System.out.println("UserServiceNormal-addUser");
    }
}
