import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xml.model.Address;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class AppXml {

    @Autowired
    @Qualifier("addr")
    private Address address;

    private Address address1;

    private Address address2;

    @Test
    public void test1() {
        System.out.println(address.getCity());
        System.out.println(address.getId());
    }
}
