package com.xhh.dp.factory.func;

import com.xhh.dp.factory.BMW;
import com.xhh.dp.factory.ICar;

public class BMWFactory implements IFactory {

    @Override
    public ICar getCar() {
        return new BMW();
    }

}
