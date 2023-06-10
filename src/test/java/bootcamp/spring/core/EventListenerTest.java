package bootcamp.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import bootcamp.spring.core.listener.LoginSuccessListener;
import bootcamp.spring.core.service.UserService;

public class EventListenerTest {

    @Configuration
    @Import({
        UserService.class,
        LoginSuccessListener.class
    })
    public static class ConfigurationTest{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ConfigurationTest.class);
    }

    @Test
    void eventListenerTest(){

        UserService userService = applicationContext.getBean(UserService.class);

        userService.login("admin", "admin");
        userService.login("this", "wrong");
        userService.login("that", "wrong");
    }
}
