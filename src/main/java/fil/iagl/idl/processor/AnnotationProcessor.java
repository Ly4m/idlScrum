package fil.iagl.idl.processor;

import java.util.ArrayList;

import fil.iagl.idl.ScrumApplication;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtMethod;

public class AnnotationProcessor extends AbstractProcessor<CtMethod<?>> {

	@Override
	public boolean isToBeProcessed(CtMethod<?> candidate) {
		return candidate.getAnnotation(
				getFactory().Type().createReference("fil.iagl.opl.rendu.two.processors.CorrespondingTask")) != null;
	}

	@Override
	public void process(CtMethod<?> element) {
		String className = element.getParent().getSignature() + "." + element.getSimpleName();
		if (!ScrumApplication.associationMap.keySet().contains(className.substring(6))) {
			ScrumApplication.associationMap.put(className, new ArrayList<String>());
		}
		for (CtAnnotation annotation : element.getAnnotations()) {
			if (annotation.getType().equals(
					getFactory().Type().createReference("fil.iagl.opl.rendu.two.processors.CorrespondingTask"))) {
				System.out.println(annotation.getElementValue("taskName"));
				ScrumApplication.associationMap.get(className).add(annotation.getElementValue("taskName").toString());
			}
		}
	}

}
