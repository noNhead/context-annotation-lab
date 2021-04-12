package org.shop.logger;

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
    private final Map<String,Class> classMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName){
        LOGGER.info("postProcessorBeforeInit start for: {}", beanName);
        Class beanClass = bean.getClass();
        classMap.put(beanName, beanClass);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName){
        LOGGER.info("postProcessorAfterInit start for: {}", beanName);
        LOGGER.info("classMap size is: {}", classMap.size());
        Class beanClass = classMap.get(beanName);
        if(beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(),
                    beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    LOGGER.info("Start {}", method);
                    Object value = method.invoke(bean,args);
                    LOGGER.info("End {}",method);
                    return value;
                }
            });
        }
        return bean;
    }
}
