package com.xhh.dp.factory.func;

import com.xhh.dp.factory.Benz;
import com.xhh.dp.factory.ICar;

public class BenzFactory implements IFactory{

    @Override
    public ICar getCar() {
        return new Benz();
    }

}
