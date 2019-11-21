package com.xhh.dp.strategy;

/**
 * 策略A， 数字比较器
 *
 */
public class NumberCompartor implements Compartor{

    @Override
    public int compareTo(Object a, Object b) {
        System.out.println("数字比较器策略");
        return 0;
    }

}
