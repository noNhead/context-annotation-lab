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
    private static final Logger LOGGER = LoggerFactory.getLogger(FactoryConfiguration.class);
    @Bean
    public UserRepositoryFactory userRepositoryFactory() {
        LOGGER.info("userRepositoryFactory start");
        return new UserRepositoryFactory();
    }

    @Bean
    public OrderMapRepository orderMapRepository() {
        return new OrderMapRepository();
    }
}
