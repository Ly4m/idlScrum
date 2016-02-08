package fil.iagl.idl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface CorrespondingTasks {
	CorrespondingTask[] value();
}
