package fil.iagl.idl.processor;


public class AnnotationProcessor extends spoon.processing.AbstractProcessor<spoon.reflect.declaration.CtAnnotation<fil.iagl.idl.annotation.CorrespondingTask>> {
    @java.lang.Override
    public boolean isToBeProcessed(spoon.reflect.declaration.CtAnnotation<fil.iagl.idl.annotation.CorrespondingTask> candidate) {
        try {
            java.lang.System.out.println(("HAAAAAAAAAAAAa : " + (candidate.getActualAnnotation().taskName())));
            java.lang.System.out.println(((("HAAAAAAAAAAAAa : " + (candidate.getAnnotatedElement().getParent().getSignature())) + ".") + (((spoon.reflect.declaration.CtMethod)(candidate.getAnnotatedElement())).getSimpleName())));
        } catch (java.lang.ClassCastException ex) {
            return false;
        }
        return super.isToBeProcessed(candidate);
    }

    @java.lang.Override
    public void process(spoon.reflect.declaration.CtAnnotation<fil.iagl.idl.annotation.CorrespondingTask> arg0) {
    }
}

