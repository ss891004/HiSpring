package org.example.dao;

/**
 * 此类不能被扫描，不能加@Component
 */
public class UserDaoNormal implements UserDao {
    public UserDaoNormal() {
        System.out.println("UserDaoNormal-NoneConstructor");
    }

    @Override
    public void addUser() {
        System.out.println("UserDaoNormal-addUser");
    }
}
