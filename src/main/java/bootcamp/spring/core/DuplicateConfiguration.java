package bootcamp.spring.core;

import org.springframework.context.annotation.Bean;
import bootcamp.spring.core.data.Foo;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DuplicateConfiguration {
    
    @Bean
    public Foo foo1(){
        return new Foo();
    }

    @Bean
    public Foo foo2(){
        return new Foo();
    }
}
