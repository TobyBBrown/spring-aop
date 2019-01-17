package com.toby.springaop.aspect;

import com.toby.springaop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

    @Before("allCirclemethods()")
    public void LoggingAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.toString());
        System.out.println(joinPoint.getTarget());
        Circle circle = (Circle) joinPoint.getTarget();
    }

//    @Before("allGetters()")
//    public void secondAdvice() {
//        System.out.println("Second Advice");
//    }

    // @After runs even if target method does not complete successfully

//    @AfterReturning(pointcut = "args(name)", returning = "returnValue")
//    public void stringArgMethods(String name, String returnValue) {
//        System.out.println("A method that takes a String arguments");
//        System.out.println("Name: " + name);
//    }
//
//    @AfterThrowing(pointcut = "args(name)", throwing = "exception")
//    public void exceptionAdvice(String name, Exception exception) {
//        System.out.println("An exception was thrown");
//    }

    @Around("allGetters()") // Advice code for both before and after target method
    // must return that value from the target method else it will be lost
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) { // proceedingJoinPoint is compulsory
        // Executes target method, not mandatory (can just act as a before)

        Object returnValue;

        try {
            System.out.println("Before around advice");
            returnValue = proceedingJoinPoint.proceed();
            System.out.println("After returning around advice");
        } catch (Throwable throwable) {
            System.out.println("After throwing");
            returnValue = new Object();
        }

        System.out.println("After (finally) around advice");
        return returnValue;
    }


    @Pointcut("execution(public * get*(..))")
    public void allGetters() {}

    @Pointcut("within(com.toby.springaop.model.Circle)")
    public void allCirclemethods() {}

}
