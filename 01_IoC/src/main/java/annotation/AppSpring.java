package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AppSpring {

    public static void main(String[] args) {

        // 通过注解的方式，去扫描所有的组件，
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
