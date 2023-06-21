package bootcamp.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import bootcamp.spring.core.data.House;
import bootcamp.spring.core.processor.IdGeneratorBeanPostProcessor;
import bootcamp.spring.core.processor.PrefixIdGeneratorBeanPostProcessor;

public class OrderedTest {
    
    @Configuration
    @Import({
        House.class,
        IdGeneratorBeanPostProcessor.class,
        PrefixIdGeneratorBeanPostProcessor.class,
    })
    public static class TestConfiguration{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();  //Automatically to close the connection
    }

    @Test
    void houseTest(){
        House house = applicationContext.getBean(House.class);

        Assertions.assertNotNull(house.getId());     
        Assertions.assertTrue(house.getId().startsWith("PREFIX - "));   
    }

}
