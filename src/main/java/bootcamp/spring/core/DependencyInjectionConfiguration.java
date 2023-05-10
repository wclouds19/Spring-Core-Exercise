package bootcamp.spring.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import bootcamp.spring.core.data.Foo;
import bootcamp.spring.core.data.Bar;
import bootcamp.spring.core.data.FooBar;
import org.springframework.context.annotation.Primary;

@Configuration
public class DependencyIjectionConfiguration {
    
    @Primary
    @Bean
    public Foo fooFirst(){
        return new Foo();
    }

    @Bean
    public Foo fooSecond(){
        return new Foo();
    }

    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public FooBar fooBar(@Qualifier("fooSecond") Foo foo, Bar bar){
        return new FooBar(foo, bar);
    }
}
