package com.zdk.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
//构造、set、XXX、init、XXX、destroy
//后处理器
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后处理1");
        System.out.println("后处理1"+"bean"+"   :+beanName");
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后处理2");
        System.out.println("后处理2"+"bean"+"   :+beanName");
        return bean;
    }
}
