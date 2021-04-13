package org.shop.config;

//import org.shop.logger.LoggersConf;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@Import({ApiConfiguration.class,
        DataInitializerConfiguration.class,
        FactoryConfiguration.class,
        RepositoryConfig.class
})
@ComponentScan("org.shop.logger")
@ComponentScan("org.shop.config")
public class RootConfiguration {
    /*@Bean
    public LoggerWithoutAspectJ loggerWithoutAspectJ() {
        return new LoggerWithoutAspectJ();
    }
*/}
