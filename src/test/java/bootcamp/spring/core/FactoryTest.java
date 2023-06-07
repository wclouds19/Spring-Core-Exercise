package bootcamp.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bootcamp.spring.core.client.PaymentGatewayClient;

public class FactoryTest {
    
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(FactoryConfiguration.class);
        applicationContext.registerShutdownHook(); ////Automatically to close the connection 
    }

    @Test
    void factoryTest(){
        PaymentGatewayClient paymentGatewayClient = applicationContext.getBean(PaymentGatewayClient.class);

        Assertions.assertNotNull(paymentGatewayClient);
        Assertions.assertEquals("https://www.test.com", paymentGatewayClient.getEndPoint());
        Assertions.assertEquals("aabbccddee", paymentGatewayClient.getPrivateKey());
        Assertions.assertEquals("eeddccbbaa", paymentGatewayClient.getPublicKey());
    }
}
