package fil.iagl.idl.annotation;


@java.lang.annotation.Target(value = java.lang.annotation.ElementType.METHOD)
@java.lang.annotation.Repeatable(value = fil.iagl.idl.annotation.CorrespondingTasks.class)
public @interface CorrespondingTask {
    java.lang.String taskName() default "";
}

