package bootcamp.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import bootcamp.spring.core.data.Foo;
import bootcamp.spring.core.processor.FooBeanFactoryPostProcessor;

public class BeanFactoryPostProcessorTest {

    @Configuration
    @Import({
        FooBeanFactoryPostProcessor.class
    })
    public static class ConfigurationTest{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ConfigurationTest.class);
    }

    @Test
    void beanFactoryPostProcessorTest(){
        Foo foo = applicationContext.getBean(Foo.class);

        Assertions.assertNotNull(foo);
    }
}
