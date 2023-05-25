package bootcamp.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bootcamp.spring.core.repository.CustomerRepository;
import lombok.Getter;

@Component
public class CustomerService {

    @Getter
    @Autowired
    private CustomerRepository customerRepository;

}
