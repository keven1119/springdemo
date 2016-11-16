package com.keven.spring.advices;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by keven on 16/11/16.
 */
public class TestAdvice implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object proceed = methodInvocation.proceed();

        System.out.println("TestAdvice   invoke  被调用");
        return null;
    }
}
