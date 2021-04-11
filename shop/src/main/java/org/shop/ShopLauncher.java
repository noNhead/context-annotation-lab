package org.shop;


import org.shop.config.RootConfiguration;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShopLauncher.class);
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        //TODO: implement using Spring Framework ApplicationContext
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfiguration.class);
        ProposalInitializer propInitializer = applicationContext.getBean(ProposalInitializer.class);
        LOGGER.debug(propInitializer.getClass().getName());
    }
}
