package xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.model.Address;
import xml.model.User;
import xml.service.MessagesPrinter;


public class App {
    public static void main(String[] args) {

        //初始化，会将xml文件中所有bean对象进行初始化
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-bean.xml");
        //获取bean对象
        MessagesPrinter mp= ac.getBean("messagesPrinter",MessagesPrinter.class);
        mp.printer();
        System.out.println(">>>>>>>>>>");
        Address addr= ac.getBean("addr",Address.class);
        System.out.println(addr.getId());
        System.out.println(addr.getCity());

        User user = ac.getBean("user",User.class);


        System.out.printf("~~~~~");
    }
}
