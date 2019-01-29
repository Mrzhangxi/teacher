package com.zx.teachers.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class authorizeAspect {

    @Pointcut("execution(public * com.zx.teachers.Controller.User*.*(..))")
    public void verify(){}

    @Before("verify()")
    public void doVerify() {
        System.out.println("Aspect执行了");
    }
}
