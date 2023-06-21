package bootcamp.spring.core.command;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LogCommandLineRunner implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        log.info("Log Command Line Runner : {}", Arrays.toString(args));
    }    
}
