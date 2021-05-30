package com.joubo.apisuperheroes.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

  @Around("@annotation(TrackTime)")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    Object response = joinPoint.proceed();
    long timeTaken = System.currentTimeMillis() - startTime;
    log.info("Tiempo de ejecución: {} ms", timeTaken);
    return response;
  }

}