package com.toby.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(public String com.toby.springaop.model.Circle.getName())")
    public void LoggingAdvice() {
        System.out.println("Get method called.");
    }
}
