package bootcamp.spring.core.runner;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SimpleRunner implements ApplicationRunner{
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> profile = args.getOptionValues("profile") ;
        log.info("Profile : {}", profile);    
    }    
}
