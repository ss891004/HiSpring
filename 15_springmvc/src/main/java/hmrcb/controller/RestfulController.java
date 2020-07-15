package hmrcb.controller;

import hmrcb.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestfulController {

    @GetMapping("/users")
    public List<User> queryAllUsers() {

        List<User> user = Arrays.asList(new User(), new User());
        return user;
    }

    @GetMapping("/users/{id}")
    public String queryOneUser(@PathVariable Integer id) {
        return "{status:2}";
    }


    @PostMapping("/users")
    public String addUser(User user) {
        System.out.println(user);
        return "{status:1}";
    }

    @PutMapping("/users")
    public String updateUser(User user) {
        System.out.println(user);
        return "{status:3}";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return "{status:4}";
    }


}
