package com.xhh.dp.singleton;

/**
 * 实现方式有很多，这是最经典的写法
 *
 */
public class Singleton {

    private static class LazyHoler {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static final Singleton getInstance() {
        return LazyHoler.INSTANCE;
    }

    private Singleton() {

    }
}
