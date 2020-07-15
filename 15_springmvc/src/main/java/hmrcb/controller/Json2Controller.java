package hmrcb.controller;

import hmrcb.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @RestController 等价于在每个在每个方法上都加上 @ResponseBody
@RestController
@RequestMapping("/json2")
public class Json2Controller {

    //以json格式响应客户端
    @RequestMapping("/hi1")
    public User hi1() {
        User user = new User();
        user.setId(1);
        user.setName("xxxx");
        return user;
    }

    @RequestMapping("/hi2")
    public User hi2() {
        User user = new User(1, "xxxx", true, null, 23);
        return user;
    }

    @RequestMapping(value = "/hi3", produces = "text/html;charset=utf-8")
    public String hi3() {
        return "你好！！！";
    }

    //从客户端接收json文
    //todo


}
