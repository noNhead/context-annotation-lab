package org.shop.config;

import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.api.impl.ProductServiceImpl;
import org.shop.api.impl.UserServiceImpl;
import org.shop.data.User;
import org.shop.repository.ProductRepository;
import org.shop.repository.map.ProductMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAspectJAutoProxy
public class DataInitializerConfiguration {
    @Bean
    public SellerInitializer sellerInitializer(Map<Long, String> sellerNames) {
        return new SellerInitializer();
    }

    @Bean
    public Map<Long, String> beanMapsSellerNames() {
        return new HashMap<>();
    }

    @Bean(name = "proposalInitializer")
    public ProposalInitializer propInit() {
        return new ProposalInitializer();
    }

    @Bean
    public ProductInitializer productInitializer() {
        ProductRepository repository = new ProductMapRepository();
        ProductService productService = new ProductServiceImpl(repository);
        return new ProductInitializer(productService);
    }

    @Bean
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }

    @Bean
    public UserInitializer userInitializer(UserService userService) {
        return new UserInitializer(userService);
    }
}
