package org.example;

import org.springframework.stereotype.Component;

/**
 * CD唱片类
 */
@Component
public class CompactDisc {

    public CompactDisc() {
        System.out.println("CompactDisc-NoneConstructor");

    }

    public  void  discPlay(){
        System.out.println("CompactDisc-discPlay");
    }
}
