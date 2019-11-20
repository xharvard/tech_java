package com.xhh.dp.factory.abs;

import com.xhh.dp.factory.Benz;
import com.xhh.dp.factory.ICar;

public class BenzFactory extends AbsFactory{

    @Override
    public ICar getCar() {
        return new Benz();
    }

}
