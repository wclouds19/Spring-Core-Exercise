package bootcamp.spring.core.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import bootcamp.spring.core.data.Foo;

@SpringBootApplication
public class FooApplication {
    
    @Bean
    public Foo foo(){
        return new Foo();
    }

    public static void main(String[] args){
        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);

        Foo foo = applicationContext.getBean(Foo.class);

        System.out.println(foo);
    }
}
