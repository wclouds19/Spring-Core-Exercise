package bootcamp.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bootcamp.spring.core.data.Connection;
import bootcamp.spring.core.data.Server;

@Configuration
public class LiveCycleConfiguration {
    
    @Bean
    public Connection connection(){
        return new Connection();
    }

    //@Bean(initMethod = "start", destroyMethod = "stop")  disable when no using @PostConstruct, @PreDestroy
    @Bean
    public Server server(){
        return new Server();
    }
}
