package com.hvs.lab.sales.components.aspects.implementations;

import com.hvs.lab.sales.components.aspects.contracts.ILoggerAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class LoggerAspect implements ILoggerAspect {

    @Override
    @Around("@annotation(com.hvs.lab.sales.components.aspects.annotations.TimeTakenLogger)")
    public Object executionMethodTime(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime startTime = LocalDateTime.now();
        log.info("starting method: {}", joinPoint.getSignature().getName());
        Object rsp = joinPoint.proceed();
        log.info("end method, Time Taken: {} ms", Duration.between(startTime, LocalDateTime.now()).toMillis());
        return rsp;
    }

}
