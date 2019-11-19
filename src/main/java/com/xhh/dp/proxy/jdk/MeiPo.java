package com.xhh.dp.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理必须实现InvocationHandler
 * 
 * 通过Proxy.newProxyInstance()方法返回代理类
 */
public class MeiPo implements InvocationHandler {

    private Person target;

    public Person getInstance(Person target) {
        this.target = target;
        Class<? extends Person> clazz = target.getClass();
        return (Person) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===开始相亲===");
        method.invoke(target, args);
        System.out.println("===结束相亲===");
        return null;
    }

}
