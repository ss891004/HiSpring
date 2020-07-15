package hmrcb.controller;

import hmrcb.entity.User;
import hmrcb.entity.UserList;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello1")
    public String hello1() {
        System.out.println("hello this is hello1 function!!!!");
        return "index";  //index.jsp
    }

    @RequestMapping("/hello2")
    public String hello2() {
        System.out.println("hello this is hello2 function");
        return "views/users"; // views/users.jsp
    }

    @RequestMapping("/hello3")
    //请求参数和方法形参同名即可
    //日期默认格式: YYYY/MM/dd HH:mm:ss ,可以通过@DateTimeFormat 进行修改
    public String hello3(Integer id, String name, Boolean gender, @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss") Date birth) {
        //http://localhost:8080/15_springmvc/hello/hello3?id=1&name=%E6%89%93%E7%AE%97&gender=false&birth=2020-07-10%2010:32:32
        System.out.println(id + " " + name + " " + gender + " " + birth);

        return "index";

    }

    @RequestMapping("/hello4")
    //请求参数和实体属性同名即可
    //日期默认格式: YYYY/MM/dd HH:mm:ss ,可以通过@DateTimeFormat 进行修改
    public String hello4(User user) {
        //http://localhost:8080/15_springmvc/hello/hello4?id=1&name=%E6%89%93%E7%AE%97&gender=false&birth=2020-07-10%2010:32:32
        System.out.println(user);

        return "index";
    }

    @RequestMapping("/hello5")
    //简单类型的数组
    public String hello5(String[] hobby) {
        //http://localhost:8080/15_springmvc/hello/hello5?hobby=a&hobby=b&hobby=c

        for (String h : hobby) {
            System.out.println(h);
        }

        return "index";
    }

    @RequestMapping("/hello6")
    public String hello6(UserList ul) {
        //http://localhost:8080/15_springmvc/hello/hello6?users[0].id=1&user[0].name=xxx&users[1].id=2&user[1].name=yyy

        for (User u : ul.getUsers()) {
            System.out.println(u);
        }

        return "index";
    }

    @RequestMapping("/hello7/{id}")
    //http://localhost:8080/15_springmvc/hello/hello7/10
    public String hello7(@PathVariable("id") Integer no) {
        System.out.println(no);
        return "index";
    }



}