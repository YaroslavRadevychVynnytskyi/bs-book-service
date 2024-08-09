package com.application.bsbookservice.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {
    private final Logger logger;

    @Before("execution(* com.application.bsbookservice.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        logger.info("Method " + joinPoint.getSignature().getName() + " is called");
    }
}
