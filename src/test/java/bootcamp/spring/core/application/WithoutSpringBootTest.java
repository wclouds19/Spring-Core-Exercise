package bootcamp.spring.core.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bootcamp.spring.core.data.Foo;

public class WithoutSpringBootTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(FooApplication.class);
        applicationContext.registerShutdownHook();  //Automatically to close the connection
    }

    @Test
    void withoutSpringBootTest(){

        Foo foo = applicationContext.getBean(Foo.class);

    }
}
