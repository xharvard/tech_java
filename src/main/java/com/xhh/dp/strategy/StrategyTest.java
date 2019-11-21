package com.xhh.dp.strategy;

import org.junit.Test;

/**
 * 策略模式
 *
 */
public class StrategyTest {

    @Test
    public void test1() {
        MyList list = new MyList();
        // 用字符比较策略
        list.sort(new StringCompartor());
    }
}
