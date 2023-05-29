package bootcamp.spring.core;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bootcamp.spring.core.data.Bar;
import bootcamp.spring.core.data.Foo;
import bootcamp.spring.core.data.FooBar;

@Configuration
public class OptionalConfiguration {
    
    @Bean
    public Foo foo(){
        return new Foo();
    }
    
    @Bean
    public FooBar fooBar(Optional<Foo> foo, Optional<Bar> bar){
        //Optional mean its a parameters allow or no
        return new FooBar(foo.orElse(null), bar.orElse(null));
    }
}
