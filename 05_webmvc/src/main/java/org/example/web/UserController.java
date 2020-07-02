package org.example.web;

import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
        System.out.println("UserController-UserServiceConstructor");
    }

    public UserController() {
        System.out.println("UserController-NoneConstructor");
    }

    public void addUser(){

        userService.addUser();
        System.out.println("UserController-addUser");

    }
}
