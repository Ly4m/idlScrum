package fil.iagl.opl.rendu.two.processors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
public @interface CorrespondingTasks {
    CorrespondingTask[] value();
}

