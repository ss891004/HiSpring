package org.example.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("UserDaoImpl-NoneConstructor");
    }

    @Override
    public void addUser() {
        System.out.println("UserDaoImpl-addUser");
    }
}
