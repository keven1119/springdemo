package com.keven.spring.interceptors;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by keven on 16/11/15.
 */
public class LoggerExecute implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        methodInvocation.proceed();
        return null;
    }

    private void before(){
        System.out.println("程序开始执行！");
    }
}
