package com.xhh.dp.proxy.jdk;

import org.junit.Test;

public class JdkProxyTest {

    @Test
    public void test1() {
        //被代理对象
        Person person = new Derian();
        //获取代理类
        Person proxyPerson = new MeiPo().getInstance(person);
        proxyPerson.xiangQin();
    }
}
