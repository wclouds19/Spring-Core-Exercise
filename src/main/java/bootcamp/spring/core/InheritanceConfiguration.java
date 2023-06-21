package bootcamp.spring.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import bootcamp.spring.core.service.MerchantServiceImplementation;

@Configuration
@Import({
    MerchantServiceImplementation.class
})
public class InheritanceConfiguration {
    
}
