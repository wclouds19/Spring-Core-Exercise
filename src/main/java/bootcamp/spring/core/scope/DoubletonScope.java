package bootcamp.spring.core.scope;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.lang.Nullable;

public class DoubletonScope implements Scope {

    private List<Object> objects = new ArrayList<>(2);
    private Long counter = -1l;

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        counter++;

        if(objects.size() == 2){
            int index = (int) (counter%2);
            return objects.get(index);
        }else{
            Object object = objectFactory.getObject();
            objects.add(object);
            return object;
        }
    }

    @Override
    public Object remove(String name) {

        if(!objects.isEmpty()){
            return objects.remove(0);
        }

        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerDestructionCallback'");
    }

    @Override
    @Nullable
    public Object resolveContextualObject(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resolveContextualObject'");
    }

    @Override
    @Nullable
    public String getConversationId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConversationId'");
    } 
}
