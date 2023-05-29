package bootcamp.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bootcamp.spring.core.data.MultiFoo;
import bootcamp.spring.core.repository.CategoryRepository;
import bootcamp.spring.core.repository.CustomerRepository;
import bootcamp.spring.core.repository.ProductRepository;
import bootcamp.spring.core.service.CategoryService;
import bootcamp.spring.core.service.CustomerService;
import bootcamp.spring.core.service.ProductService;

public class ComponentTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        applicationContext.registerShutdownHook();  //Automatically to close the connection
    }

    @Test
    void serviceTest(){
        ProductService service1 = applicationContext.getBean(ProductService.class);
        ProductService service2 = applicationContext.getBean("productService", ProductService.class);

        Assertions.assertSame(service1, service2);
    }

    @Test
    void constructorDiTest(){
        ProductService service = applicationContext.getBean(ProductService.class);
        ProductRepository repository = applicationContext.getBean(ProductRepository.class);

        Assertions.assertSame(repository, service.getProductRepository());
    }

    @Test
    void setterDiTest(){
        CategoryService service = applicationContext.getBean(CategoryService.class);
        CategoryRepository repository = applicationContext.getBean(CategoryRepository.class);

        Assertions.assertSame(repository, service.getCategoryRepository());
    }

    @Test
    void fieldDiTest(){
        //This method is no longer recomended
        CustomerService service = applicationContext.getBean(CustomerService.class);
        //CustomerRepository repository = applicationContext.getBean(CustomerRepository.class);
        CustomerRepository normalCustomerRepository = applicationContext.getBean("normalCustomerRepository", CustomerRepository.class);
        CustomerRepository premiumCustomerRepository = applicationContext.getBean("premiumCustomerRepository", CustomerRepository.class);

        //Assertions.assertSame(repository, service.getCustomerRepository());
        Assertions.assertSame(normalCustomerRepository, service.getNormalCustomerRepository());
        Assertions.assertSame(premiumCustomerRepository, service.getPremiumCustomerRepository());
    }

    @Test
    void objectProviderTest(){
        MultiFoo multiFoo = applicationContext.getBean(MultiFoo.class);
        Assertions.assertEquals(3, multiFoo.getFoo().size());
    }
}
