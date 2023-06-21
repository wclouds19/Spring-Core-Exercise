package bootcamp.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import bootcamp.spring.core.service.AuthService;

public class AwareTest {
    
    @Configuration
    @Import({
        AuthService.class
    })
    public static class ConfigurationTest{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ConfigurationTest.class);
    }

    @Test
    void awareTest(){
        AuthService authService = applicationContext.getBean(AuthService.class);

        Assertions.assertEquals("bootcamp.spring.core.service.AuthService", authService.getBeanName());
        Assertions.assertNotNull(authService.getApplicationContext());
        Assertions.assertSame(applicationContext, authService.getApplicationContext());
    }
}
