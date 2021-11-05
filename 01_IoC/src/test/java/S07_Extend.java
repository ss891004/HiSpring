import extend.ServiceB;
import extend.ServiceC;
import hm.LazyInitBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class S07_Extend {

    @Test
    public void Test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beanExtend.xml");
        System.out.println(context.getBean(ServiceB.class));
        System.out.println(context.getBean(ServiceC.class));

    }

    @Test
    public void Test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beanExtend.xml");
        System.out.println(context.getBean("e4"));
        System.out.println(context.getBean("e5"));

    }


}
