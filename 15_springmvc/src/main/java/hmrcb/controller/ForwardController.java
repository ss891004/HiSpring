package hmrcb.controller;

import hmrcb.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@RequestMapping("/forw")
public class ForwardController {

    @RequestMapping("/hi1")
    public String hi1(){
        System.out.println("test forward1");
        return "forward:/views/users.jsp";
    }

    @RequestMapping("/hi2")
    public String hi2(){
        System.out.println("test forward2");
        //return "forward:hi1";//相对路径，转发到本类中的方法
        return "forward:/forw/hi1";//绝对路径
    }


    @RequestMapping("/hi3")
    public String hiData(HttpSession session, HttpServletRequest req,Integer id){
        session.setAttribute("user",new User());
        req.setAttribute("age",10);
        req.setAttribute("users", Arrays.asList(new User(),new User()));

        return "test2";

    }

}
