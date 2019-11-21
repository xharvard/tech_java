package com.xhh.dp.strategy;

/**
 * 策略B， 字符串比较器
 *
 */
public class StringCompartor implements Compartor {

    @Override
    public int compareTo(Object a, Object b) {
        System.out.println("字符串比较器策略");
        return 0;
    }

}
