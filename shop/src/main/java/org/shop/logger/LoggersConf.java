package org.shop.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggersConf {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* * (..))")
    public void anyMethod(JoinPoint jp){
        String fullMethodName = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
        LOGGER.info("Entering in pointcut");
        LOGGER.info("Entering method [{}]", fullMethodName);
    }

}
