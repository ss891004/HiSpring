package hm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) //由SpringJUnit4ClassRunner启动测试
@ContextConfiguration(classes = AppConfig.class) //spring的配置文件位置
public class AppTest {//当前测试类也会被纳入工厂中，所以其属性可以注入

    /**
     * 自动装配
     */
    @Autowired //注入要测试的组件
    private CDPlayer cdPlayer;

    @Test
    public void tet1() {
        cdPlayer.play();
    }
}
