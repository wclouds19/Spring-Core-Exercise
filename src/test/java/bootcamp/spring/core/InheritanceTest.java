package bootcamp.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bootcamp.spring.core.service.MerchantService;
import bootcamp.spring.core.service.MerchantServiceImplementation;

public class InheritanceTest {
    
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
        applicationContext.registerShutdownHook(); ////Automatically to close the connection 
    }

    @Test
    void factoryTest(){
        MerchantService merchantService = applicationContext.getBean(MerchantService.class);
        MerchantServiceImplementation merchantServiceImplementation = applicationContext.getBean(MerchantServiceImplementation.class);

        Assertions.assertSame(merchantService, merchantServiceImplementation);

    }
}
