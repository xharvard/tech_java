package com.xhh.dp.delegate;

import org.junit.Test;

public class DelegateTest {

    @Test
    public void test1() {
        // 执行者A
        Dispatcher dispatcher = new Dispatcher(new ExecutorA());
        dispatcher.doTask();
    }
}
