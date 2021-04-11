package org.shop.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.aspectj.lang.annotation.Aspect;

@Configuration
@Aspect
public class LoggersConf {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* * *(..))")
    public void anyPublicMethod(ProceedingJoinPoint pjp){
        String fullMethodName = pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();
        if(!pjp.getSignature().getName().equals("initBinder")) {
            LOGGER.debug("Entering method [{}]", fullMethodName);
        }
    }

}
