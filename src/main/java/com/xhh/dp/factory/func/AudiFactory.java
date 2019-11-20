package com.xhh.dp.factory.func;

import com.xhh.dp.factory.Audi;
import com.xhh.dp.factory.ICar;

public class AudiFactory implements IFactory{

    @Override
    public ICar getCar() {
        return new Audi();
    }

}
