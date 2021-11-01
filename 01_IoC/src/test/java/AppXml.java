import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xml.model.Address;
import xml.model.Student;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class AppXml {

    @Autowired
    @Qualifier("addr")
    private Address address;

    private Address address1;

    private Address address2;

    @Autowired
    @Qualifier("student")
    private Student student; //调用有参的构造函数

    @Autowired
    @Qualifier("student2")
    private Student student2; //调用无参的构造函数



    //=============================================
    //创建bean实例

    @Test
    public void test2() {
        //通过反射调用构造方法创建bean对象
        //student 和 student2
        System.out.println("~~~~~~");
    }

    @Test
    public void test3(){
        //通过静态工厂方法创建bean对象

    }

    @Test
    public void test4(){
        //通过实例工厂方法创建bean对象

    }

    @Test
    public void test5(){
        //通过FactoryBean来创建bean对象

    }




}
