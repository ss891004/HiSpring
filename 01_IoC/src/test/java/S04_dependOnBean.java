import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class S04_dependOnBean {

    @Test
    public void Test1(){

        /*
        无依赖的bean创建顺序和定义的顺序一致，销毁顺序刚好相反。
        通过构造器强依赖的bean，会先创建构造器参数中对应的bean，然后才会创建当前bean，销毁顺序刚好相反。
        depend-on可以指定档期bean依赖的bean，通过这个可以确保depend-on指定的bean在当前bean创建之前先创建好，销毁顺序刚好相反。
        */

        System.out.println("容器启动中!");
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("spring-dependOnBean.xml");
        System.out.println("容器启动完毕，准备关闭spring容器!");
        context.close();
        System.out.println("spring容器已关闭!");
    }
}
