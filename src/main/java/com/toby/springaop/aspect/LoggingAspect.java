package com.toby.springaop.aspect;

import com.toby.springaop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Before("allCirclemethods()")
    public void LoggingAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.toString());
        System.out.println(joinPoint.getTarget());
        Circle circle = (Circle) joinPoint.getTarget();
    }

    @Before("allGetters()")
    public void secondAdvice() {
        System.out.println("Second Advice");
    }

    @Before("args(name)")
    public void stringArgMethods(String name) {
        System.out.println("A method that takes a String arguments");
        System.out.println("Name: " + name);
    }

    @Pointcut("execution(public * get*(..))")
    public void allGetters() {}

    @Pointcut("within(com.toby.springaop.model.Circle)")
    public void allCirclemethods() {}

}
