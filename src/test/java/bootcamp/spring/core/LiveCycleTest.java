package bootcamp.spring.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bootcamp.spring.core.data.Connection;
import bootcamp.spring.core.data.Server;

public class LiveCycleTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(LiveCycleConfiguration.class);
        applicationContext.registerShutdownHook();  //Automatically to close the connection
    }

    @AfterEach
    void tearDown(){
        applicationContext.close();   //Manually to close the connection
    } 

    @Test
    void testConnection(){
        Connection connection = applicationContext.getBean(Connection.class); 
    }

    @Test
    void testServer(){
        Server server = applicationContext.getBean(Server.class); 
    }
    
}
