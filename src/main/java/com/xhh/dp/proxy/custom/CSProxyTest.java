package com.xhh.dp.proxy.custom;

import org.junit.Test;

import com.xhh.dp.proxy.jdk.Derian;
import com.xhh.dp.proxy.jdk.Person;

/**
 * 自定义实现JDK的动态代理过程
 *
 */
public class CSProxyTest {

    @Test
    public void test1() {
        // 被代理对象
        Person person = new Derian();
        // 获取代理类
        Person proxyPerson = new CSMeiPo().getInstance(person);
        proxyPerson.xiangQin();
    }
}
