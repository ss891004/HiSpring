import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xml.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-DI-Constructor.xml")
public class S02_DI {


    @Autowired
    @Qualifier("DIByConstructorParamIndex")
    private Student student1;

    @Autowired
    @Qualifier("DIByConstructorParamType")
    private Student student2;

    @Autowired
    @Qualifier("DIByConstructorParamName")
    private Student student3;




    @Test
    public void Test1() {
        //根据构造器参数索引注入

/*参数位置的注入对参数顺序有很强的依赖性，若构造函数参数位置被人调整过，会导致注入出错。

不过通常情况下，不建议去在代码中修改构造函数，如果需要新增参数的，可以新增一个构造函数来实现，这算是一种扩展，不会影响目前已有的功能。*/

        System.out.println(student1.toString());

    }

    @Test
    public void Test2() {
        //根据构造器参数类型注入

        System.out.println(student2.toString());
    }

    @Test
    public void Test3() {
        //根据构造器参数名称注入
        System.out.println(student3.toString());

    }


}
