package com.zdk.advice;

import org.aopalliance.intercept.Invocation;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//环绕通知
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("sx begin~~~");
        Object ret = methodInvocation.proceed();
        System.out.println("sx end!!!");

        return ret ;
    }
}
