package com.alexspooner.petspring.api.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ControllerExceptionAspect {

    @Pointcut("execution(public * *(..)) && within(com.alexspooner.petspring.api.*Controller)")
    private void pointcut() {
    }

    @Around("pointcut()")
    public Object logExceptionIfHappens(ProceedingJoinPoint proceedingJoinPoint) {
        Object result;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
            return ResponseEntity.badRequest()
                    .body(throwable.getMessage());
        }

        return result;
    }
}
