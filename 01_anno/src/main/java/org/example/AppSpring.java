package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AppSpring {

    public static void main(String[] args) {
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppSpring.class);
 /*
        MessageService ms = ac.getBean(MessageService.class);
        MessagesPrinter mp = ac.getBean(MessagesPrinter.class);
        mp.setMessageService(ms);
        mp.printer();
*/

        //在 setMessageService 增加注解 @Autowired
        //获取bean对象
        MessagesPrinter mp = ac.getBean(MessagesPrinter.class);
        mp.printer();

    }
}
