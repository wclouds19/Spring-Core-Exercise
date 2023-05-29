package bootcamp.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import bootcamp.spring.core.data.MultiFoo;

@Configuration
@ComponentScan(basePackages = {
    "bootcamp.spring.core.service",
    "bootcamp.spring.core.repository",
    "bootcamp.spring.core.configuration"
})
@Import(MultiFoo.class)
public class ComponentConfiguration {
    
}
