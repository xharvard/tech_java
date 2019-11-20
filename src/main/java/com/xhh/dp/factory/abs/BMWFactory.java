package com.xhh.dp.factory.abs;

import com.xhh.dp.factory.BMW;
import com.xhh.dp.factory.ICar;

public class BMWFactory extends AbsFactory {

    @Override
    public ICar getCar() {
        return new BMW();
    }

}
