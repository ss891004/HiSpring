package hm;

import org.springframework.stereotype.Component;

/**
 * 电源类
 */
@Component
public class Power {

    public Power() {
        System.out.println("Power-NoneConstructor");
    }

    public void supply() {
        System.out.println("Power-supply");
    }

}
