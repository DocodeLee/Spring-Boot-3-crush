package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        // print out  method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n===>> Executing @Around on method : " + method);

        // get begin time tamp
        long begin =System.currentTimeMillis();
        // now, let's execute the method
        Object result = null;

        try{
            result = theProceedingJoinPoint.proceed();
        }
        catch (Exception exc) {
             // log exception
            System.out.println(exc.getMessage());

            // rethrow the exception
            throw exc;
        }


        // get end timeStamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n ======> Duration : " + duration / 1000.0 + " seconds");
        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===>> Executing @After (finally) on method : " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===>> Executing @AfterThrowing on method : " + method);

        // log the exception
        System.out.println("\n===>> The Exception is : " + theExc);


    }


    // add a new advice for @AfterReturning on the find Accounts method
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result) {

        //print out which method we are advising
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===>> Executing @AfterReturning on method : " + method);

        // print out the result of the method call
        System.out.println("\n===>> result : " + result);

        //let's post-process data ... let's modify it

        //convert the account name to UpperCase
        convertAccountNameToUpperCase(result);

        System.out.println("\n =====>>> result is : " + result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {

        // loop through accounts
        for(Account tempAccount :result){
            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }
    }


    // return type , package, class,method,params
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){

        System.out.println("\n=====>> Executing @Before advice on method");

        // display the method signature

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru  args
        for(Object tempArg : args){
            System.out.println(tempArg);

            if (tempArg instanceof Account){

                //downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("Account Name " + theAccount.getName());
                System.out.println("Account level " + theAccount.getLevel());
            }
        }
    }
}
