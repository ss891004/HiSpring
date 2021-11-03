import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xml.model.Student;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-bean.xml")
public class S01_bean {


    @Autowired
    @Qualifier("student1")
    private Student student1; //调用有参的构造函数

    @Autowired
    @Qualifier("student2")
    private Student student2; //调用无参的构造函数


    @Autowired
    @Qualifier("student3")
    private Student student3;

    @Autowired
    @Qualifier("student4")
    private Student student4;


    @Autowired
    @Qualifier("student5")
    private Student student5;

    @Autowired
    @Qualifier("student6")
    private Student student6;

    @Autowired
    @Qualifier("createByFactoryBean")
    private Student student7;

    @Autowired
    @Qualifier("createByFactoryBean")
    private Student student8;

    //=============================================
    //创建bean实例
    @Test
    public void test2() {
        //通过反射调用构造方法创建bean对象
        //student1 和 student2
        System.out.println(student1.toString());
        System.out.println(student2.toString());
    }

    @Test
    public void test3(){
        //通过静态工厂方法创建bean对象
        // student3   和 student4
        System.out.println(student3.toString());
        System.out.println(student4.toString());
    }

    @Test
    public void test4(){
        //通过实例工厂方法创建bean对象
        System.out.println(student5.toString());
        System.out.println(student6.toString());
    }

    @Test
    public void test5(){
        //通过FactoryBean来创建bean对象
        System.out.println(student7.toString());
        System.out.println(student8.toString());

    }

}
