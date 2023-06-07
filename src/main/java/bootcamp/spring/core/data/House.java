package bootcamp.spring.core.data;

import org.springframework.stereotype.Component;

import bootcamp.spring.core.aware.IdAware;
import lombok.Getter;

@Component
public class House implements IdAware {
    
    @Getter
    private String Id;

    @Override
    public void setId(String id) {
        this.Id = id;
    }
}
