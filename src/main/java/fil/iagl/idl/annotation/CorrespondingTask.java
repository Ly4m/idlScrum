package fil.iagl.idl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Repeatable(value = CorrespondingTasks.class)
public @interface CorrespondingTask {
	String taskName() default "";
}
