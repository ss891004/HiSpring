package hmrcb.controller;

import hmrcb.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("/hi1")
    @ResponseBody
    public User hi1(){
        User user = new User();
        user.setId(1);
        user.setName("xxxx");
        return user;
    }

    @RequestMapping("/hi2")
    public @ResponseBody User hi2(){
        User user = new User(1,"xxxx",true,null,23 );
        return user;
    }

    @RequestMapping(value = "/hi3", produces = "text/html;charset=utf-8")
    public @ResponseBody String hi3(){
        return "你好！！！";
    }

}
