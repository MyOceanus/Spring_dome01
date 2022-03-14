package com.zdk.advice;

import org.springframework.aop.ThrowsAdvice;
//核心抛出异常时，执行
public class MyThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex){
        System.out.println("my throws");
    }

}
