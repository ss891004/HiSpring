package hmrcb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redir")
public class RedirectController {

    @RequestMapping("/hi1")
    public String hi1(){
        System.out.println("test Redirect1");
        return "redirect:/views/users.jsp";
    }

    @RequestMapping("/hi2")
    public String hi2(){
        System.out.println("test Redirect2");
        //return "redirect:hi1";//相对路径，转发到本类中的方法
        return "redirect:/redir/hi1";//绝对路径
    }

}
