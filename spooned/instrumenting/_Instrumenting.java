package instrumenting;

import spoon.processing.AbstractProcessor;
import fil.iagl.opl.rendu.two.processors.AddWatcherProcessor;
import fil.iagl.opl.rendu.two.App;
import fil.iagl.opl.rendu.two.AppTest;
import javafx.application.Application;
import java.util.ArrayList;
import java.util.Arrays;
import org.fest.assertions.Assertions;
import javafx.scene.chart.BarChart;
import fil.iagl.opl.rendu.two.insert.impl.BasicInsert;
import fil.iagl.opl.rendu.two.insert.impl.BeforeInsert;
import fil.iagl.opl.rendu.two.processors.BeforeInsertTest;
import fil.iagl.opl.rendu.two.samples.BeforeSample;
import java.io.BufferedReader;
import javafx.scene.control.Button;
import fil.iagl.opl.rendu.two.insert.impl.CaseInsert;
import fil.iagl.opl.rendu.two.processors.CaseInsertTest;
import fil.iagl.opl.rendu.two.insert.impl.CatchInsert;
import fil.iagl.opl.rendu.two.processors.CatchInsertTest;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.paint.Color;
import fil.iagl.opl.rendu.two.processors.ConstructorCoolTest;
import fil.iagl.opl.rendu.two.insert.impl.ConstructorInsert;
import fil.iagl.opl.rendu.two.processors.ConstructorInsertTest;
import fil.iagl.opl.rendu.two.samples.ConstructorSample;
import fil.iagl.opl.rendu.two.tools.ContainsSameElementFilter;
import fil.iagl.opl.rendu.two.processors.CorrespondingTask;
import fil.iagl.opl.rendu.two.processors.CorrespondingTasks;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCase;
import spoon.reflect.code.CtCatch;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.code.CtDo;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtForEach;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtSwitch;
import spoon.reflect.code.CtSynchronized;
import spoon.reflect.code.CtTry;
import spoon.reflect.code.CtWhile;
import fil.iagl.opl.rendu.two.insert.impl.DoInsert;
import fil.iagl.opl.rendu.two.processors.DoInsertTest;
import fil.iagl.opl.rendu.two.insert.impl.DoNotInsert;
import fil.iagl.opl.rendu.two.samples.DoSample;
import java.lang.annotation.ElementType;
import javafx.collections.FXCollections;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.apache.commons.io.FileUtils;
import spoon.reflect.visitor.Filter;
import javafx.scene.layout.FlowPane;
import fil.iagl.opl.rendu.two.insert.impl.ForInsert;
import fil.iagl.opl.rendu.two.processors.ForInsertTest;
import fil.iagl.opl.rendu.two.samples.ForSample;
import java.util.HashMap;
import java.util.HashSet;
import java.io.IOException;
import fil.iagl.opl.rendu.two.insert.impl.IfInsert;
import fil.iagl.opl.rendu.two.processors.IfInsertTest;
import fil.iagl.opl.rendu.two.samples.IfSample;
import fil.iagl.opl.rendu.two.insert.Insertion;
import spoon.Launcher;
import com.sun.javafx.charts.Legend;
import java.util.List;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import java.util.Map;
import fil.iagl.opl.rendu.two.insert.impl.MethodInsert;
import fil.iagl.opl.rendu.two.processors.MethodInsertTest;
import fil.iagl.opl.rendu.two.samples.MethodSample;
import fil.iagl.opl.rendu.two.insert.NoInsertionFound;
import javafx.scene.Node;
import javafx.scene.chart.NumberAxis;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import java.util.function.Predicate;
import java.util.Random;
import javafx.scene.shape.Rectangle;
import java.lang.annotation.Repeatable;
import javafx.scene.Scene;
import java.util.Set;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import fil.iagl.opl.rendu.two.insert.impl.SwitchInsert;
import fil.iagl.opl.rendu.two.processors.SwitchInsertTest;
import fil.iagl.opl.rendu.two.samples.SwitchSample;
import fil.iagl.opl.rendu.two.insert.impl.SynchronizedInsert;
import fil.iagl.opl.rendu.two.processors.SynchronizedInsertTest;
import fil.iagl.opl.rendu.two.samples.SynchronizedSample;
import java.lang.annotation.Target;
import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import fil.iagl.opl.rendu.two.TestTest;
import javafx.scene.text.Text;
import fil.iagl.opl.rendu.two.insert.impl.TryInsert;
import fil.iagl.opl.rendu.two.processors.TryInsertTest;
import fil.iagl.opl.rendu.two.samples.TrySample;
import fil.iagl.opl.rendu.two.insert.impl.WhileInsert;
import fil.iagl.opl.rendu.two.processors.WhileInsertTest;
import fil.iagl.opl.rendu.two.samples.WhileSample;
import javafx.scene.chart.XYChart;

public class _Instrumenting {
    private static final char TEXTUAL_ARRAY_CHAR = '#';

    private static final char TEXTUAL_ARRAY_SIZE = 20;

    public static String TMP_FILE_NAME;

    public static String CURRENT_DIR;

    public static Map<java.lang.String, java.util.Map<java.lang.Integer, java.lang.Boolean>> lines = new HashMap<java.lang.String, java.util.Map<java.lang.Integer, java.lang.Boolean>>();

    public static void addInstrumentedClass(String qualifiedName) {
        if ((_Instrumenting.lines.get(qualifiedName)) == null) {
            System.out.printf("Intrumenting %s ...\n", qualifiedName);
            _Instrumenting.lines.put(qualifiedName, new HashMap<java.lang.Integer, java.lang.Boolean>());
        } 
    }

    public static void addInstrumentedStatement(String qualifiedName, int position) {
        _Instrumenting.lines.get(qualifiedName).put(position, false);
    }

    public static void isPassedThrough(String qualifiedName, final int position) {
        if (_Instrumenting.lines.isEmpty()) {
            _Instrumenting.init();
        } 
        _Instrumenting.lines.get(qualifiedName).put(position, true);
    }

    @SuppressWarnings(value = "unchecked")
    private static void init() {
        try {
            FileInputStream fin = new FileInputStream(new File(_Instrumenting.TMP_FILE_NAME));
            ObjectInputStream ois = new ObjectInputStream(fin);
            _Instrumenting.lines = ((Map<java.lang.String, java.util.Map<java.lang.Integer, java.lang.Boolean>>)(ois.readObject()));
            ois.close();
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                    }
                }
            } , "Shutdown-thread"));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    _OverallBarChart.run();
                }
            }).start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayResultPerPackageInConsole(String packageName) {
        String commonPackage;
        if (packageName == null) {
            commonPackage = _Instrumenting.getLongestCommonPrefix(_Instrumenting.lines.keySet().toArray(new String[_Instrumenting.lines.keySet().size()]));
            commonPackage = commonPackage.substring(0, ((commonPackage.length()) - 1));
        } else {
            commonPackage = packageName;
        }
        Float nbLineExecuted = 0.0F;
        Float nbLineTotal = 0.0F;
        for (Map.Entry<java.lang.String, java.util.Map<java.lang.Integer, java.lang.Boolean>> entry : _Instrumenting.lines.entrySet()) {
            if (entry.getKey().startsWith(commonPackage)) {
                for (boolean isExecuted : entry.getValue().values()) {
                    if (isExecuted) {
                        nbLineExecuted++;
                    } 
                }
                nbLineTotal += entry.getValue().size();
            } 
        }
        Float covergeRatio = nbLineExecuted / nbLineTotal;
        String arrayTab = "";
        int nbArrayChar = ((int)((TEXTUAL_ARRAY_SIZE) * covergeRatio));
        for (int i = 0 ; i < nbArrayChar ; i++)
            arrayTab += TEXTUAL_ARRAY_CHAR;
        System.out.format("%-40s[%-20s] %.2f%%%n", commonPackage, arrayTab, (covergeRatio * 100));
        Set<java.lang.String> subDirectPackage = new HashSet<java.lang.String>();
        for (Map.Entry<java.lang.String, java.util.Map<java.lang.Integer, java.lang.Boolean>> entry : _Instrumenting.lines.entrySet()) {
            if ((entry.getKey().substring(0, entry.getKey().lastIndexOf(".")).contains(commonPackage)) && ((entry.getKey().substring(0, entry.getKey().lastIndexOf(".")).split("\\.").length) > (commonPackage.split("\\.").length))) {
                subDirectPackage.add(String.format("%s.%s", commonPackage, entry.getKey().split("\\.")[commonPackage.split("\\.").length]));
            } 
        }
        if (!(subDirectPackage.isEmpty())) {
            for (String subPackage : subDirectPackage) {
                _Instrumenting.displayResultPerPackageInConsole(subPackage);
            }
        } 
    }

    public static void displayResultPerClassInConsole() {
        for (Map.Entry<java.lang.String, java.util.Map<java.lang.Integer, java.lang.Boolean>> entry : _Instrumenting.lines.entrySet()) {
            Float nbLineExecuted = 0.0F;
            for (boolean isExecuted : entry.getValue().values()) {
                if (isExecuted) {
                    nbLineExecuted++;
                } 
            }
            Float covergeRatio = nbLineExecuted / (entry.getValue().size());
            System.out.printf("%s -> %.2f%%\n", entry.getKey(), covergeRatio);
        }
    }

    private static String getLongestCommonPrefix(String[] strings) {
        if ((strings.length) == 0) {
            return "";
        } 
        for (int prefixLen = 0 ; prefixLen < (strings[0].length()) ; prefixLen++) {
            char c = strings[0].charAt(prefixLen);
            for (int i = 1 ; i < (strings.length) ; i++) {
                if ((prefixLen >= (strings[i].length())) || ((strings[i].charAt(prefixLen)) != c)) {
                    return strings[i].substring(0, prefixLen);
                } 
            }
        }
        return strings[0];
    }
}

