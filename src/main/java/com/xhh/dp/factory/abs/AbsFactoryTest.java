package com.xhh.dp.factory.abs;

import org.junit.Test;

public class AbsFactoryTest {

    @Test
    public void test1() {
        DefaultFactory factory = new DefaultFactory();
        System.out.println(factory.getCar("benz").getName());
    }
}
