package org.shop.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.StaticApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class CustomBeanFactory {
    private final Map<String, Object> singletons = new HashMap<>();

    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }

    @Bean
    public BeanFactory beanFactory(){
        return null;
    }

}
