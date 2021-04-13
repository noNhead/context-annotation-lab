package org.shop.logger;

import org.shop.DataInitializer;
import org.shop.config.ApiConfiguration;
import org.shop.config.DataInitializerConfiguration;
import org.shop.config.RepositoryConfig;
import org.shop.config.RootConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoggerWithoutAspectJ implements BeanPostProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerWithoutAspectJ.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName){
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName){
        if(beanName.equals("dataInitializer")) {
            LOGGER.info("Entering PPAI with dataInitializer");
            Class beanClass = bean.getClass();
            return Proxy.newProxyInstance(beanClass.getClassLoader(),
                    beanClass.getInterfaces(), (proxy, method, args) -> {
                        LOGGER.info("Start {}", method);
                        return method.invoke(bean,args);
                    });
        }
        return bean;
    }
}
