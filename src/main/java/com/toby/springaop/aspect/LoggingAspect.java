package com.toby.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Before("allGetters() && allCirclemethods() ")
    public void LoggingAdvice() {
        System.out.println("Get method called.");
    }

    @Before("allGetters()")
    public void secondAdvice() {
        System.out.println("Second Advice");
    }

    @Pointcut("execution(public * get*(..))")
    public void allGetters() {}

    @Pointcut("within(com.toby.springaop.model.Circle)")
    public void allCirclemethods() {}

    @Pointcut("args(com.toby.springaop.model.Circle)")
    public void circleArgs() {}
}
