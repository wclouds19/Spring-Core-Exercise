package bootcamp.spring.core.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import bootcamp.spring.core.aware.IdAware;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PrefixIdGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered{

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        
        log.info("Prefix ID Generator Processor for Bean {}", beanName);

        if(bean instanceof IdAware){

            log.info("Prefix Set ID Generator for Bean {}", beanName);

            IdAware idAware = (IdAware) bean;
            idAware.setId("PREFIX - " + idAware.getId());
        }

        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }
    
}
