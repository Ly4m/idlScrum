package fil.iagl.opl.rendu.two.processors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Repeatable(value = CorrespondingTasks.class)
public @interface CorrespondingTask {
    String taskName() default "";
}

