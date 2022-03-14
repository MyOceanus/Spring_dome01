package com.zdk.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
//前置通知类
public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        //Additional functionality
        System.out.println("transaction control 2");
        System.out.println("journal printer 2");

    }
}
