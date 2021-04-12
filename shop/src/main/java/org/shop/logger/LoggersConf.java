package org.shop.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@Aspect
@EnableAspectJAutoProxy
public class LoggersConf {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* * (..))")
    public void anyMethodAround(){
        LOGGER.info("anyMethodAround");
    }

    @Around("execution(* * (..))")
    public void anyMethod(ProceedingJoinPoint pjp){
        String fullMethodName = pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();
        LOGGER.info("Entering in pointcut");
        if(!pjp.getSignature().getName().equals("initBinder")) {
            LOGGER.debug("Entering method [{}]", fullMethodName);
        }
    }

}
