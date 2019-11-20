package com.xhh.dp.factory.simple;

import com.xhh.dp.factory.Audi;
import com.xhh.dp.factory.BMW;
import com.xhh.dp.factory.Benz;
import com.xhh.dp.factory.ICar;

/**
 * 简单工厂模式
 *
 */
public class CarSimpleFactory {

    ICar getCar(String name) {
        if ("Audi".equalsIgnoreCase(name)) {
            return new Audi();
        } else if ("Benz".equalsIgnoreCase(name)) {
            return new Benz();
        } else if ("BMW".equalsIgnoreCase(name)) {
            return new BMW();
        } else {
            return null;
        }
    }
}
