package com.xhh.dp.factory.abs;

import com.xhh.dp.factory.ICar;

/**
 * 抽象工厂模式
 *
 * 结合简单工厂和工厂方法2个模式，简单工厂内部调用工厂方法来生产产品
 */
public abstract class AbsFactory {

    protected abstract ICar getCar();

    ICar getCar(String name) {
        if ("Audi".equalsIgnoreCase(name)) {
            return new AudiFactory().getCar();
        } else if ("Benz".equalsIgnoreCase(name)) {
            return new BenzFactory().getCar();
        } else if ("BMW".equalsIgnoreCase(name)) {
            return new BMWFactory().getCar();
        } else {
            return null;
        }
    }
}
