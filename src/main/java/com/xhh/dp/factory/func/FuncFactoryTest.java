package com.xhh.dp.factory.func;

import org.junit.Test;

public class FuncFactoryTest {

    @Test
    public void test1() {
        //各个产品有自己的工厂
        IFactory factory = new AudiFactory();
        System.out.println(factory.getCar().getName());

        factory = new BenzFactory();
        System.out.println(factory.getCar().getName());
    }
}
