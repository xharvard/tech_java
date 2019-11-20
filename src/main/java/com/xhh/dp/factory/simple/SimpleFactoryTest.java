package com.xhh.dp.factory.simple;

import org.junit.Test;

import com.xhh.dp.factory.ICar;

public class SimpleFactoryTest {

    @Test
    public void test1() {
        ICar car = new CarSimpleFactory().getCar("Audi");
        System.out.println(car.getName());
    }
}
