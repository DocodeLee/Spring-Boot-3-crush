package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut declaration
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    // do the same thing with for service and dao

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    // add before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info( " =====>> in Before : calling method " + theMethod);

        //display the arguments to the method

        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop thru and display args
        for(Object tempArgs : args){
            myLogger.info("======>> argument : " + tempArgs);
        }
    }

    // after returning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){

        // display method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info( " =====>> in @AfterReturning : Returning method " + theMethod);


        // display data returned

        myLogger.info("======> result: " + theResult);

    }

}
