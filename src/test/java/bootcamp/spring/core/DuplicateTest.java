package bootcamp.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import bootcamp.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;

public class DuplicateTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
    }
    
    @Test
    void testDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            Foo foo = applicationContext.getBean(Foo.class);
        });       
    }

    @Test
    void testGetBean(){
        Foo foo1 = applicationContext.getBean("foo1", Foo.class);
        Foo foo2 = applicationContext.getBean("foo2",Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }
}
