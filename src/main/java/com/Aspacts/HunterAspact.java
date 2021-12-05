package com.Aspacts;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HunterAspact {

    @Pointcut(value = "execution(public * com.Servicers.HunterActions .*())")
    public void pointCutAsync() { }

    @Around("pointCutAsync()")
    public void asyncFilter(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("  point Cut!!!!  ");

        // 這裏只有 1 個方法，是你去調用了具體某一個方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(methodSignature.getMethod().getName());
        joinPoint.proceed();
    }

}
