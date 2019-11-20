package com.xhh.dp.proxy.cglib;

import org.junit.Test;

public class CgLibProxyTest {

    @Test
    public void test1(){
        Tom meipo = (Tom) new MeiPo().getInstance(Tom.class);
        meipo.xiangQin();
    }
}
