package bootcamp.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

import bootcamp.spring.core.data.Foo;
import bootcamp.spring.core.data.Bar;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DependsOnConfiguration {
    
    @Lazy  //Bean is not created until it access
    @Bean
    @DependsOn({"bar"})  //Created the bar first
    public Foo foo(){
        log.info("Create a New Foo");
        return new Foo();
    }

    @Bean
    public Bar bar(){
        log.info("Create a New Bar");
        return new Bar();
    }
}
