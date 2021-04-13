package org.shop.config;

import org.shop.repository.*;
import org.shop.repository.map.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.shop.repository.factory.UserRepositoryFactory;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
@PropertySource("config.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RepositoryConfig {
    private final Environment env;

    public RepositoryConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public UserRepository userRepository(UserRepositoryFactory userRepositoryFactory) {
        return userRepositoryFactory.createUserRepository();
    }

    @Bean
    public OrderRepository orderRepository(OrderMapRepository orderMapRepository) {
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

    @Bean
    public ItemRepository itemRepository(){
        return new ItemMapRepository();
    }

    @Bean
    public SellerRepository sellerRepository(){
        return new SellerMapRepository();
    }
}
