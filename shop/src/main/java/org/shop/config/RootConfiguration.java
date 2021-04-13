package org.shop.config;

//import org.shop.logger.LoggersConf;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({ApiConfiguration.class,
        DataInitializerConfiguration.class,
        FactoryConfiguration.class,
        RepositoryConfig.class
})
@ComponentScan("org.shop.logger")
@ComponentScan("org.shop.config")
public class RootConfiguration {

}
