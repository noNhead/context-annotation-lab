package org.shop.config;

import org.shop.api.UserService;
import org.shop.api.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ApiConfiguration {
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
