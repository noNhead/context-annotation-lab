package org.shop.config;

import org.shop.repository.factory.UserRepositoryFactory;
import org.shop.repository.map.OrderMapRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class FactoryConfiguration {
    @Bean
    public UserRepositoryFactory userRepositoryFactory() {
        return new UserRepositoryFactory();
    }

    @Bean
    public OrderMapRepository orderMapRepository() {
        return new OrderMapRepository();
    }
}
