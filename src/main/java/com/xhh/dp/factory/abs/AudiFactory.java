package com.xhh.dp.factory.abs;

import com.xhh.dp.factory.Audi;
import com.xhh.dp.factory.ICar;

public class AudiFactory extends AbsFactory{

    @Override
    public ICar getCar() {
        return new Audi();
    }

}
