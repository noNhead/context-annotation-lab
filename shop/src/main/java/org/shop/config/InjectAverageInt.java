package org.shop.config;

import org.shop.annotations.RandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

public class InjectAverageInt implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();

        Arrays.stream(fields).forEach(field -> {
            RandomInt annotation = field.getAnnotation(RandomInt.class);
            if (annotation != null) {
                int min = annotation.minValue();
                int max = annotation.maxValue();
                int average = (min+max)/2;
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, average);
            }
        });
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
