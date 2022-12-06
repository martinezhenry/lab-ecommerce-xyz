package com.hvs.lab.sales.components.aspects.contracts;

import org.aspectj.lang.ProceedingJoinPoint;

public interface ILoggerAspect {
    Object executionMethodTime(ProceedingJoinPoint joinPoint) throws Throwable;
}
