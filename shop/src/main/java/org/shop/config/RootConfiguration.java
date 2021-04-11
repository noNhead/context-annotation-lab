package org.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@Import({ApiConfiguration.class,
        DataInitializerConfiguration.class,
        FactoryConfiguration.class,
        RepositoryConfig.class})
public class RootConfiguration {
}
