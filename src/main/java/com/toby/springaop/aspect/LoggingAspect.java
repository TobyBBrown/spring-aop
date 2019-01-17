package com.toby.springaop.aspect;

import com.toby.springaop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

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

    // @After runs even if target method does not complete successfully

    @AfterReturning(pointcut = "args(name)", returning = "returnValue")
    public void stringArgMethods(String name, String returnValue) {
        System.out.println("A method that takes a String arguments");
        System.out.println("Name: " + name);
    }

    @AfterThrowing(pointcut = "args(name)", throwing = "exception")
    public void exceptionAdvice(String name, Exception exception) {
        System.out.println("An exception was thrown");
    }

    @Pointcut("execution(public * get*(..))")
    public void allGetters() {}

    @Pointcut("within(com.toby.springaop.model.Circle)")
    public void allCirclemethods() {}

}
