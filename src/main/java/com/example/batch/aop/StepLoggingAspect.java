package com.example.batch.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.batch.core.Step;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class StepLoggingAspect {

    // Before a step starts
    @Before("execution(* org.springframework.batch.core.Step+.execute(..))")
    public void logBeforeStep(JoinPoint joinPoint) {
        Step step = (Step) joinPoint.getTarget();
        log.info("➡ AOP️ Starting Step: {}", step.getName());
    }

    // After a step finishes
    @AfterReturning("execution(* org.springframework.batch.core.Step+.execute(..))")
    public void logAfterStep(JoinPoint joinPoint) {
        Step step = (Step) joinPoint.getTarget();
        log.info("✅ AOP Finished Step: {}", step.getName());
    }
}
