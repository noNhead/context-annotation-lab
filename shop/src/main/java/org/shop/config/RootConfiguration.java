package org.shop.config;

//import org.shop.logger.LoggersConf;
import org.shop.logger.LoggerWithoutAspectJ;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@Import({ApiConfiguration.class,
        DataInitializerConfiguration.class,
        FactoryConfiguration.class,
        RepositoryConfig.class
})
@ComponentScan("org.shop")
public class RootConfiguration {
    @Bean
    public LoggerWithoutAspectJ loggerWithoutAspectJ() {
        return new LoggerWithoutAspectJ();
    }
}
