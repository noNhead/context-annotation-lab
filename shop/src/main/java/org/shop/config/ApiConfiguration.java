package org.shop.config;

import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.api.UserService;
import org.shop.api.impl.ProductServiceImpl;
import org.shop.api.impl.ProposalServiceImpl;
import org.shop.api.impl.SellerServiceImpl;
import org.shop.api.impl.UserServiceImpl;
import org.shop.repository.ProductRepository;
import org.shop.repository.ProposalRepository;
import org.shop.repository.map.ProductMapRepository;
import org.shop.repository.map.ProposalMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
public class ApiConfiguration {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProposalRepository proposalRepository;

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public SellerService sellerService() {
        return new SellerServiceImpl();
    }

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    public ProposalService proposalService() {
        return new ProposalServiceImpl(proposalRepository);
    }
}
