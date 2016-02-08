package fil.iagl.opl.rendu.two;


@java.lang.annotation.Target(value = java.lang.annotation.ElementType.METHOD)
@java.lang.annotation.Repeatable(value = fil.iagl.opl.rendu.two.CorrespondingTasks.class)
public @interface CorrespondingTask {
    java.lang.String taskName() default "";
}

