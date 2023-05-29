package bootcamp.spring.core.data;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class MultiFoo {
    
    @Getter
    private List<Foo> foo;

    public MultiFoo(ObjectProvider<Foo> objectProvider){
        //ObjectProvider its same with Optional but if can collect all the bean
        foo = objectProvider.stream().collect(Collectors.toList());    
    }
}
