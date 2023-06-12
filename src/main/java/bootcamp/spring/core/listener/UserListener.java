package bootcamp.spring.core.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import bootcamp.spring.core.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserListener {
    
    @EventListener(classes = LoginSuccessEvent.class)
    public void onLoginSuccessEvent(LoginSuccessEvent event){
        log.info("Success Login for User {}", event.getUser());
    }
}
