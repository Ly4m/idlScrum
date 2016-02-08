package fil.iagl.opl.rendu.two.processors;

import spoon.processing.AbstractProcessor;
import java.util.Arrays;
import org.fest.assertions.Assertions;
import fil.iagl.opl.rendu.two.insert.impl.BeforeInsert;
import fil.iagl.opl.rendu.two.insert.impl.CaseInsert;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtDo;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtSwitch;
import spoon.reflect.code.CtWhile;
import java.lang.annotation.ElementType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import fil.iagl.opl.rendu.two.insert.Insertion;
import spoon.Launcher;
import java.util.List;
import java.io.ObjectOutputStream;
import java.util.function.Predicate;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;
import org.junit.Test;
import instrumenting._Instrumenting;

public class CaseInsertTest {
    @Test
    @CorrespondingTask(taskName = "task2")
    @CorrespondingTask(taskName = "task1")
    public void instrumentSwitchTest() throws Exception {
        Launcher l = new Launcher();
        l.addInputResource("src/test/java");
        l.buildModel();
        CtClass<?> sample = ((CtClass<?>)(l.getFactory().Package().getRootPackage().getElements(new spoon.reflect.visitor.filter.NameFilter<spoon.reflect.declaration.CtNamedElement>("SwitchSample")).get(0)));
        Integer nbCase = 8;
        Integer nbStatementToInsert = 8;
        Insertion insertionStrategy = new CaseInsert();
        CtStatement statementToInsert = l.getFactory().Code().createCodeSnippetStatement("TO BE INSERT");
        Assertions.assertThat(sample.getElements(new spoon.reflect.visitor.filter.TypeFilter<spoon.reflect.declaration.CtElement>(CtElement.class)).stream().filter(insertionStrategy::match).collect(java.util.stream.Collectors.toList())).hasSize(nbCase);
        sample.getElements(new spoon.reflect.visitor.filter.TypeFilter<spoon.reflect.declaration.CtElement>(CtElement.class)).stream().filter(insertionStrategy::match).forEach((CtElement element) -> insertionStrategy.apply(element, statementToInsert));
        System.out.println(sample);
        Assertions.assertThat(sample.getElements(new fil.iagl.opl.rendu.two.tools.ContainsSameElementFilter(statementToInsert))).hasSize(nbStatementToInsert);
    }
}

