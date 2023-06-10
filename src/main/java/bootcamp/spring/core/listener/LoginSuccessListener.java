package bootcamp.spring.core.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import bootcamp.spring.core.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccessListener implements ApplicationListener<LoginSuccessEvent>{
    
    
    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        log.info("Success Login for User {}", event.getUser());
    }
}
