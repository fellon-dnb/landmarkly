package com.fellon.landmarkly.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.fellon.landmarkly.service.*.*(..))")
    public void logBefore() {
        System.out.println("метод выполняемый в контроллере");
    }
}
