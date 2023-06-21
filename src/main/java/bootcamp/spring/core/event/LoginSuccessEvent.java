package bootcamp.spring.core.event;

import org.springframework.context.ApplicationEvent;

import bootcamp.spring.core.data.User;
import lombok.Getter;

public class LoginSuccessEvent extends ApplicationEvent {
    
    @Getter
    private final User user;

    public LoginSuccessEvent(User user){
        super(user);
        this.user = user;
    }
}
