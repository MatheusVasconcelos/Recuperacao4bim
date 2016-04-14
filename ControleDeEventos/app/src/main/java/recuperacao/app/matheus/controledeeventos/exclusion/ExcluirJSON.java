package recuperacao.app.matheus.controledeeventos.exclusion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mathe on 13/04/2016.
 */

@Retention(RetentionPolicy.RUNTIME )
@Target(ElementType.FIELD )
public @interface ExcluirJSON {
}
