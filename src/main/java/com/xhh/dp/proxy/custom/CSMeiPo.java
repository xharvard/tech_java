package com.xhh.dp.proxy.custom;

import java.lang.reflect.Method;

import com.xhh.dp.proxy.jdk.Person;

/**
 * 代理必须实现InvocationHandler
 * 
 * 通过Proxy.newProxyInstance()方法返回代理类
 */
public class CSMeiPo implements CSInvocationHandler {

    private Person target;

    public Person getInstance(Person target) {
        this.target = target;
        Class<? extends Person> clazz = target.getClass();
        return (Person) CSProxy.newProxyInstance(new CSClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===自定义开始相亲===");
        method.invoke(target, args);
        System.out.println("===自定义结束相亲===");
        return null;
    }

}
