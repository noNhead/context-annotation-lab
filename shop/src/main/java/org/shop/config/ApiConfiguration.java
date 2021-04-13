package org.shop.config;

import org.shop.api.*;
import org.shop.api.impl.*;
import org.shop.repository.ItemRepository;
import org.shop.repository.ProductRepository;
import org.shop.repository.ProposalRepository;
import org.shop.repository.map.ItemMapRepository;
import org.shop.repository.map.ProductMapRepository;
import org.shop.repository.map.ProposalMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApiConfiguration {
    @Bean
    public ItemService itemService(ItemRepository itemRepository){
        return new ItemServiceImpl(itemRepository);
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl();
    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    public ProposalService proposalService(ProposalRepository proposalRepository) {
        return new ProposalServiceImpl(proposalRepository);
    }

    @Bean
    public SellerService sellerService() {
        return new SellerServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
