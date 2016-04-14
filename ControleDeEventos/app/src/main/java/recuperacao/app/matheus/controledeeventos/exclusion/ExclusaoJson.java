package recuperacao.app.matheus.controledeeventos.exclusion;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Created by mathe on 13/04/2016.
 */
public class ExclusaoJson implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return fieldAttributes.getAnnotation( ExcluirJSON.class ) != null;

    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
