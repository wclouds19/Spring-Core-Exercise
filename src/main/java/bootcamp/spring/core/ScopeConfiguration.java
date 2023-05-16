package bootcamp.spring.core;

import bootcamp.spring.core.data.Bar;
import bootcamp.spring.core.data.Foo;
import bootcamp.spring.core.scope.DoubletonScope;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ScopeConfiguration {

    @Bean
    @Scope("prototype")
    public Foo foo(){
        log.info("Create a New Foo");
        return new Foo();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new DoubletonScope());
        return configurer;
    }

    @Bean
    @Scope("doubleton")
    public Bar bar(){
        log.info("Create a New Bar");
        return new Bar();
    }

}
