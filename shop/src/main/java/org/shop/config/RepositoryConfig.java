package org.shop.config;

import org.shop.repository.OrderRepository;
import org.shop.repository.ProductRepository;
import org.shop.repository.ProposalRepository;
import org.shop.repository.UserRepository;
import org.shop.repository.map.OrderMapRepository;
import org.shop.repository.map.ProductMapRepository;
import org.shop.repository.map.ProposalMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.shop.repository.factory.UserRepositoryFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
@PropertySource("config.properties")
@EnableAspectJAutoProxy
public class RepositoryConfig {
    @Autowired
    private Environment env;

    private final UserRepositoryFactory userRepositoryFactory = new UserRepositoryFactory();
    private final OrderMapRepository orderMapRepository = new OrderMapRepository();

    @Bean
    public UserRepository userRepository() {
        return userRepositoryFactory.createUserRepository();
    }

    @Bean
    public OrderRepository orderRepository() {
        long initialSequence = Long.parseLong(Objects.requireNonNull(env.getProperty("initialSequence")));
        orderMapRepository.setSequence(initialSequence);
        return orderMapRepository;
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductMapRepository();
    }

    @Bean
    public ProposalRepository proposalRepository() {
        return new ProposalMapRepository();
    }
}
