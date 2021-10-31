package hm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * CD播放器类
 */
@Component
public class CDPlayer {


    //方法一，对成员变量自动装配
    //@Autowired
    private Power power;
    //@Autowired
    private CompactDisc compactDisc;

    public CDPlayer() {
        System.out.println("CDPlayer-NoneConstructor");
    }

    //方法二，构造函数
    //@Autowired
    public CDPlayer(Power power, CompactDisc compactDisc) {
        this.power = power;
        this.compactDisc = compactDisc;
        System.out.println("CDPlayer-AllConstructor");
    }


    public void play() {
        System.out.println(">>>>>>>>>>>>>>>>>");
        power.supply();
        System.out.println("<<<<<<<<<<<<<<<<<");
        compactDisc.discPlay();
    }


    //方法三，setter方法
    //@Autowired
    public void setPower(Power power) {
        this.power = power;
        System.out.println("CDPlayer-setPower");
    }

    //@Autowired
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
        System.out.println("CDPlayer-setCompactDisc");
    }

    //方法四，任意函数
    @Autowired
    public void ffff(Power power, CompactDisc compactDisc) {
        this.power = power;
        this.compactDisc = compactDisc;
        System.out.println("CDPlayer-ffffConstructor");
    }
}
