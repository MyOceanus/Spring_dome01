package com.zdk.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
//后置通知，在核心之后执行，如果核心有异常则不执行
public class MyAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After!!!");
    }
}
