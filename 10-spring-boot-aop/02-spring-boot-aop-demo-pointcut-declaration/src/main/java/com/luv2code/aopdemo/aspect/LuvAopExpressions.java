package com.luv2code.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
// if this class only have pointcuts @Aspect is optional

@Aspect
public class LuvAopExpressions {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){} //can have any method name

    // create a pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public void getter(){}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public void setter(){}

    // create pointcut : include package.. exclude getter / setter
    @Pointcut("forDaoPackage() && !(getter() || setter() )")
    public void forDaoPackageNoGetterSetter() {}
}
