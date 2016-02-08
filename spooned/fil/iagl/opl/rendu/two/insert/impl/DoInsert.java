package fil.iagl.opl.rendu.two.insert.impl;

import spoon.processing.AbstractProcessor;
import fil.iagl.opl.rendu.two.processors.AddWatcherProcessor;
import java.util.Arrays;
import org.fest.assertions.Assertions;
import fil.iagl.opl.rendu.two.processors.BeforeInsertTest;
import fil.iagl.opl.rendu.two.samples.BeforeSample;
import fil.iagl.opl.rendu.two.processors.CaseInsertTest;
import fil.iagl.opl.rendu.two.processors.CatchInsertTest;
import fil.iagl.opl.rendu.two.processors.ConstructorInsertTest;
import fil.iagl.opl.rendu.two.samples.ConstructorSample;
import fil.iagl.opl.rendu.two.processors.CorrespondingTask;
import fil.iagl.opl.rendu.two.processors.CorrespondingTasks;
import spoon.reflect.code.CtCase;
import spoon.reflect.code.CtCatch;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.code.CtDo;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtSwitch;
import spoon.reflect.code.CtWhile;
import fil.iagl.opl.rendu.two.processors.DoInsertTest;
import fil.iagl.opl.rendu.two.samples.DoSample;
import java.lang.annotation.ElementType;
import java.io.File;
import java.io.FileOutputStream;
import fil.iagl.opl.rendu.two.processors.ForInsertTest;
import fil.iagl.opl.rendu.two.samples.ForSample;
import java.io.IOException;
import fil.iagl.opl.rendu.two.processors.IfInsertTest;
import fil.iagl.opl.rendu.two.samples.IfSample;
import fil.iagl.opl.rendu.two.insert.Insertion;
import spoon.Launcher;
import java.util.List;
import fil.iagl.opl.rendu.two.processors.MethodInsertTest;
import fil.iagl.opl.rendu.two.samples.MethodSample;
import java.io.ObjectOutputStream;
import java.util.function.Predicate;
import java.lang.annotation.Repeatable;
import fil.iagl.opl.rendu.two.processors.SwitchInsertTest;
import fil.iagl.opl.rendu.two.samples.SwitchSample;
import fil.iagl.opl.rendu.two.processors.SynchronizedInsertTest;
import fil.iagl.opl.rendu.two.samples.SynchronizedSample;
import java.lang.annotation.Target;
import org.junit.Test;
import fil.iagl.opl.rendu.two.processors.TryInsertTest;
import fil.iagl.opl.rendu.two.samples.TrySample;
import fil.iagl.opl.rendu.two.processors.WhileInsertTest;
import fil.iagl.opl.rendu.two.samples.WhileSample;
import instrumenting._Instrumenting;

public class DoInsert implements Insertion {
    @Override
    public boolean match(CtElement element) {
        return element instanceof CtDo;
    }

    @Override
    public void apply(CtElement element, CtStatement statementToInsert) {
        CtDo ctDo = ((CtDo)(element));
        ctDo.getBody().insertBefore(statementToInsert);
    }
}

