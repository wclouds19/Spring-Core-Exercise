package bootcamp.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bootcamp.spring.core.data.Foo;
import bootcamp.spring.core.data.FooBar;

public class OptionalTest {
    
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
        applicationContext.registerShutdownHook();  //Automatically to close the connection
    }

    @Test
    void optionalTest(){
         Foo foo = applicationContext.getBean(Foo.class);
         FooBar fooBar = applicationContext.getBean(FooBar.class);

         Assertions.assertNull(fooBar.getBar());
         Assertions.assertSame(foo, fooBar.getFoo());
    }
}
