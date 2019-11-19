package com.xhh.dp.proxy.custom;

import java.lang.reflect.Method;

/**
 * 自定义的InvocationHandler
 *
 */
public interface CSInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
