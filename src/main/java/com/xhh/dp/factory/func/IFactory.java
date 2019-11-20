package com.xhh.dp.factory.func;

import com.xhh.dp.factory.ICar;

/**
 * 工厂方法模式
 *
 * 定义所有工厂的执行标准
 */
public interface IFactory {
    ICar getCar();
}
