package org.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfiguration {

    @Bean
    public int randomInt(int max, int min){
        return (max+min)/2;
    }
}
