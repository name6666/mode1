package net.jhc.app_info_mng.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    private Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    //前置增强方法
    @Before("execution(public * net.jhc.app_info_mng.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info(name + "方法开始执行");
    }

    //后置增强方法
    @AfterReturning(value = "execution(public * net.jhc.app_info_mng.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        logger.info(name + "方法的返回结果是" + result);
        System.out.println();
    }

    //final增强，无论如何都会执行
    @After(value = "execution(public * net.jhc.app_info_mng.controller.*.*(..))")
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info(name + "方法结束");
    }

    //异常抛出方法
    @AfterThrowing(value = "execution(public * net.jhc.app_info_mng.controller.*.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String name = joinPoint.getSignature().getName();
        logger.info(name + "方法抛出异常" + ex);
    }
}
