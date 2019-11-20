package com.xhh.dp.factory.abs;

import com.xhh.dp.factory.ICar;

public class DefaultFactory extends AbsFactory {

    private AudiFactory factory = new AudiFactory();

    @Override
    protected ICar getCar() {
        return factory.getCar();
    }

}
