package org.shop.config;

//import org.shop.logger.LoggersConf;
import org.shop.logger.LoggerWithoutAspectJ;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@Import({ApiConfiguration.class,
        DataInitializerConfiguration.class,
        FactoryConfiguration.class,
        RepositoryConfig.class,
//        LoggersConf.class
})
public class RootConfiguration {
    @Bean
    public LoggerWithoutAspectJ loggerWithoutAspectJ() {
        return new LoggerWithoutAspectJ();
    }
}
