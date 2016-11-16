package com.keven.spring.advices;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Created by keven on 16/11/16.
 */
public class TestStaticPointcut extends StaticMethodMatcherPointcut {
    Class<?> targetClass;

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        targetClass = aClass;
        return ("eat".equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return aClass == targetClass.getClass();
            }
        };
    }
}
