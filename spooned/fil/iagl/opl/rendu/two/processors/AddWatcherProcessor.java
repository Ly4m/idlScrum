package fil.iagl.opl.rendu.two.processors;

import spoon.processing.AbstractProcessor;
import java.util.Arrays;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtDo;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtSwitch;
import spoon.reflect.code.CtWhile;
import java.lang.annotation.ElementType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import fil.iagl.opl.rendu.two.insert.Insertion;
import java.util.List;
import java.io.ObjectOutputStream;
import java.util.function.Predicate;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;
import instrumenting._Instrumenting;

public class AddWatcherProcessor extends AbstractProcessor<spoon.reflect.declaration.CtClass<?>> {
    public static final Predicate<spoon.reflect.declaration.CtElement> needToBeInstrumented = (CtElement candidate) -> (((((((((!(candidate instanceof spoon.reflect.code.CtUnaryOperator)) && (!(candidate instanceof CtClass))) && (!(candidate instanceof spoon.reflect.code.CtBlock))) && (!(candidate.isImplicit()))) && (!(candidate instanceof spoon.reflect.code.CtLiteral))) && (!(candidate instanceof CtCodeSnippetStatement))) && (!(candidate instanceof spoon.reflect.code.CtTypeAccess))) && (!(candidate instanceof spoon.reflect.declaration.CtField))) && (!((candidate.getParent()) instanceof spoon.reflect.code.CtLambda))) && (!(AddWatcherProcessor.isInsideIfForSwitchDoWhile(candidate)));

    public static final List<fil.iagl.opl.rendu.two.insert.Insertion> filters = Arrays.asList(new fil.iagl.opl.rendu.two.insert.impl.ConstructorInsert(), new fil.iagl.opl.rendu.two.insert.impl.MethodInsert(), new fil.iagl.opl.rendu.two.insert.impl.TryInsert(), new fil.iagl.opl.rendu.two.insert.impl.CatchInsert(), new fil.iagl.opl.rendu.two.insert.impl.ForInsert(), new fil.iagl.opl.rendu.two.insert.impl.WhileInsert(), new fil.iagl.opl.rendu.two.insert.impl.DoInsert(), new fil.iagl.opl.rendu.two.insert.impl.SynchronizedInsert(), new fil.iagl.opl.rendu.two.insert.impl.IfInsert(), new fil.iagl.opl.rendu.two.insert.impl.SwitchInsert(), new fil.iagl.opl.rendu.two.insert.impl.CaseInsert(), new fil.iagl.opl.rendu.two.insert.impl.BeforeInsert(), new fil.iagl.opl.rendu.two.insert.impl.BasicInsert());

    @Override
    public boolean isToBeProcessed(CtClass<?> candidate) {
        return ((!(candidate.isAnonymous())) && ((candidate.getPackage()) != null)) && (!(candidate.getPackage().getQualifiedName().startsWith("instrumenting")));
    }

    @Override
    public void processingDone() {
        try {
            CtClass<java.lang.Object> instrumentClass = getFactory().Class().get(_Instrumenting.class);
            File tmpFile = File.createTempFile("opl_instrumented", "");
            FileOutputStream fout = new FileOutputStream(tmpFile);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(_Instrumenting.lines);
            oos.close();
            instrumentClass.getField("TMP_FILE_NAME").setDefaultExpression(getFactory().Code().createCodeSnippetExpression((("\"" + (org.apache.commons.lang3.StringEscapeUtils.escapeJava(tmpFile.getAbsolutePath()))) + "\"")));
            instrumentClass.getField("CURRENT_DIR").setDefaultExpression(getFactory().Code().createCodeSnippetExpression((("\"" + (org.apache.commons.lang3.StringEscapeUtils.escapeJava(fil.iagl.opl.rendu.two.App.INPUT_SOURCE_FOLDER))) + "\"")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void process(CtClass<?> ctClass) {
        ctClass.getElements(new spoon.reflect.visitor.filter.TypeFilter<spoon.reflect.declaration.CtElement>(CtElement.class)).stream().filter(needToBeInstrumented).forEach((CtElement statement) -> findMatcherAndApply(statement));
    }

    private void findMatcherAndApply(CtElement element) {
        instrumentLine(filters.stream().filter((Insertion filter) -> filter.match(element)).findFirst().orElse(new fil.iagl.opl.rendu.two.insert.impl.DoNotInsert()), element);
    }

    private void instrumentLine(Insertion filter, CtElement element) {
        String qualifiedName = element.getParent(CtClass.class).getQualifiedName();
        if (qualifiedName.contains("$")) {
            qualifiedName = qualifiedName.substring(0, qualifiedName.indexOf("$"));
        } 
        _Instrumenting.addInstrumentedClass(qualifiedName);
        _Instrumenting.addInstrumentedStatement(qualifiedName, element.getPosition().getLine());
        CtCodeSnippetStatement statementToInsert = getFactory().Code().createCodeSnippetStatement((((("instrumenting._Instrumenting.isPassedThrough(\"" + qualifiedName) + "\", ") + (element.getPosition().getLine())) + ")"));
        filter.apply(element, statementToInsert);
    }

    private static boolean isInsideIfForSwitchDoWhile(CtElement candidate) {
        boolean isInsideIfExpression = false;
        boolean isInsideForExpression = false;
        boolean isInsideForInit = false;
        boolean isInsideForUpdate = false;
        boolean isInsideSwitchInit = false;
        boolean isInsideDoExpression = false;
        boolean isInsideWhileExpression = false;
        if ((candidate.getParent(CtIf.class)) != null) {
            CtIf ctIf = candidate.getParent(CtIf.class);
            isInsideIfExpression = !(ctIf.getCondition().getElements(new fil.iagl.opl.rendu.two.tools.ContainsSameElementFilter(candidate)).isEmpty());
        } 
        if ((candidate.getParent(CtFor.class)) != null) {
            CtFor ctFor = candidate.getParent(CtFor.class);
            isInsideForExpression = (!((ctFor.getExpression()) == null)) && (!(ctFor.getExpression().getElements(new fil.iagl.opl.rendu.two.tools.ContainsSameElementFilter(candidate)).isEmpty()));
            isInsideForInit = (!((ctFor.getForInit()) == null)) && (ctFor.getForInit().stream().anyMatch((spoon.reflect.code.CtStatement statement) -> !(statement.getElements(new fil.iagl.opl.rendu.two.tools.ContainsSameElementFilter(candidate)).isEmpty())));
            isInsideForUpdate = (!((ctFor.getForUpdate()) == null)) && (ctFor.getForUpdate().stream().anyMatch((spoon.reflect.code.CtStatement statement) -> !(statement.getElements(new fil.iagl.opl.rendu.two.tools.ContainsSameElementFilter(candidate)).isEmpty())));
        } 
        if ((candidate.getParent(CtSwitch.class)) != null) {
            CtSwitch<?> ctSwitch = candidate.getParent(CtSwitch.class);
            isInsideSwitchInit = !(ctSwitch.getSelector().getElements(new fil.iagl.opl.rendu.two.tools.ContainsSameElementFilter(candidate)).isEmpty());
        } 
        if ((candidate.getParent(CtDo.class)) != null) {
            CtDo ctDo = candidate.getParent(CtDo.class);
            isInsideDoExpression = !(ctDo.getLoopingExpression().getElements(new fil.iagl.opl.rendu.two.tools.ContainsSameElementFilter(candidate)).isEmpty());
        } 
        if ((candidate.getParent(CtWhile.class)) != null) {
            CtWhile ctWhile = candidate.getParent(CtWhile.class);
            isInsideDoExpression = !(ctWhile.getLoopingExpression().getElements(new fil.iagl.opl.rendu.two.tools.ContainsSameElementFilter(candidate)).isEmpty());
        } 
        return (((((isInsideIfExpression || isInsideDoExpression) || isInsideForExpression) || isInsideForInit) || isInsideForUpdate) || isInsideSwitchInit) || isInsideWhileExpression;
    }
}

