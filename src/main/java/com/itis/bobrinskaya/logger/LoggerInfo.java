package com.itis.bobrinskaya.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;
import java.util.Date;


/**
 * Created by Ekaterina on 06.05.2016.
 */
@Aspect
public class LoggerInfo {
    private static Logger log = Logger.getLogger(LoggerInfo.class);

    @Before("execution(* com.itis.bobrinskaya.service.*.*(..))")
    public void logToInfoService(JoinPoint joinPoint) {
        log.info("\n" + new Date() + "\n"
                + "calling service method "
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName()
                + " with params: \n"
                + Arrays.toString(joinPoint.getArgs())
                );
    }

    @Around("execution(* com.itis.bobrinskaya.service.*.*(..))")
    public Object logToInfoController(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin =System.currentTimeMillis();
       Object proceed= joinPoint.proceed();
        long end =System.currentTimeMillis();
        log.info("metdod's time is " + (end - begin) + "ms" + "\n" );
        return proceed;
    }

}
