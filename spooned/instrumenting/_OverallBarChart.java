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
import java.lang.reflect.Field;
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
import java.util.Optional;
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
import javafx.animation.Timeline;
import javafx.scene.control.Tooltip;
import fil.iagl.opl.rendu.two.insert.impl.TryInsert;
import fil.iagl.opl.rendu.two.processors.TryInsertTest;
import fil.iagl.opl.rendu.two.samples.TrySample;
import fil.iagl.opl.rendu.two.insert.impl.WhileInsert;
import fil.iagl.opl.rendu.two.processors.WhileInsertTest;
import fil.iagl.opl.rendu.two.samples.WhileSample;
import javafx.scene.chart.XYChart;

public class _OverallBarChart extends Application {
    private BarChart<java.lang.String, java.lang.Number> chart;

    private Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>> retMap;

    private Random random;

    private void init(Stage primaryStage) {
        random = new Random();
        retMap = getAllSubPackages(Optional.empty());
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("CoCoSpoon");
        XYChart.Series<java.lang.String, java.lang.Number> series = new XYChart.Series<java.lang.String, java.lang.Number>();
        List<com.sun.javafx.charts.Legend.LegendItem> legendItems = new ArrayList<com.sun.javafx.charts.Legend.LegendItem>();
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setTickLabelsVisible(false);
        NumberAxis yAxis = new NumberAxis("Coverage (%)" , 0.0 , 100.0 , 5.0);
        chart = new BarChart<java.lang.String, java.lang.Number>(xAxis , yAxis);
        root.getChildren().add(chart);
        retMap.entrySet().forEach((Map.Entry<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>> entry) -> {
            Color c = Color.hsb(((random.nextDouble()) * 360), 1.0, 1.0);
            entry.getValue().keySet().forEach((String key) -> {
                XYChart.Data<java.lang.String, java.lang.Number> data = new XYChart.Data<java.lang.String, java.lang.Number>(key , 0 , String.format("#%02x%02x%02x", ((int)((c.getRed()) * 255)), ((int)((c.getGreen()) * 255)), ((int)((c.getBlue()) * 255))));
                series.getData().add(data);
            });
            legendItems.add(new Legend.LegendItem(entry.getKey() , new Rectangle(10 , 4 , c)));
        });
        chart.getData().add(series);
        chart.setAnimated(false);
        chart.setTitle("Real time code coverage");
        installTooltip(chart.getData().get(0).getData());
        installListener(_Instrumenting.lines.keySet());
        Legend legend = ((Legend)(chart.lookup(".chart-legend")));
        legend.getItems().clear();
        legend.getItems().addAll(legendItems);
    }

    private void installListener(Set<java.lang.String> keySet) {
        for (String map : keySet) {
            ObservableMap<java.lang.Integer, java.lang.Boolean> observedMap = FXCollections.observableMap(_Instrumenting.lines.get(map));
            observedMap.addListener(new javafx.collections.MapChangeListener<java.lang.Integer, java.lang.Boolean>() {
                @Override
                public void onChanged(javafx.collections.MapChangeListener.Change<? extends java.lang.Integer, ? extends java.lang.Boolean> changed) {
                    for (Map.Entry<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>> entry : retMap.entrySet()) {
                        for (String s2 : entry.getValue().keySet()) {
                            for (XYChart.Data<java.lang.String, java.lang.Number> data : chart.getData().get(0).getData()) {
                                if (s2.contains(data.getXValue())) {
                                    data.setYValue(computeCoverageForClass(s2));
                                    data.getNode().setStyle(("-fx-background-color: " + (data.getExtraValue())));
                                } 
                            }
                        }
                    }
                }
            });
            _Instrumenting.lines.put(map, observedMap);
        }
    }

    private void installTooltip(ObservableList<javafx.scene.chart.XYChart.Data<java.lang.String, java.lang.Number>> serie) {
        for (XYChart.Data<java.lang.String, java.lang.Number> data : serie) {
            Tooltip tooltip = new Tooltip(data.getXValue());
            hackTooltipStartTiming(tooltip);
            Tooltip.install(data.getNode(), tooltip);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    private Integer computeCoverageForClass(String className) {
        Map<java.lang.Integer, java.lang.Boolean> map = _Instrumenting.lines.get(className);
        Integer total = 0;
        Integer exec = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i)) {
                ++exec;
            } 
            ++total;
        }
        return ((int)((((double)(exec)) / total) * 100));
    }

    private Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>> getAllSubPackages(Optional<java.lang.String> optionalPackageName) {
        String commonPackage = optionalPackageName.orElseGet(() -> {
            String tmp = getLongestCommonPrefix(_Instrumenting.lines.keySet().toArray(new String[_Instrumenting.lines.keySet().size()]));
            return tmp.substring(0, ((tmp.length()) - 1));
        });
        Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>> subDirectPackages = new HashMap<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>>();
        for (Map.Entry<java.lang.String, java.util.Map<java.lang.Integer, java.lang.Boolean>> entry : _Instrumenting.lines.entrySet()) {
            if ((entry.getKey().substring(0, entry.getKey().lastIndexOf(".")).contains(commonPackage)) && ((entry.getKey().substring(0, entry.getKey().lastIndexOf(".")).split("\\.").length) > (commonPackage.split("\\.").length))) {
                String subDirectPackage = String.format("%s.%s", commonPackage, entry.getKey().split("\\.")[commonPackage.split("\\.").length]);
                subDirectPackages.put(subDirectPackage, getAllClasses(Optional.of(subDirectPackage), Optional.empty()));
            } 
        }
        return subDirectPackages;
    }

    private Map<java.lang.String, java.lang.Integer> getAllClasses(Optional<java.lang.String> optionalPackageName, Optional<java.util.Map<java.lang.String, java.lang.Integer>> optionalRetMap) {
        Map<java.lang.String, java.lang.Integer> retMap = optionalRetMap.orElseGet(() -> new HashMap<java.lang.String, java.lang.Integer>());
        String commonPackage = optionalPackageName.orElseGet(() -> {
            String tmp = getLongestCommonPrefix(_Instrumenting.lines.keySet().toArray(new String[_Instrumenting.lines.keySet().size()]));
            return tmp.substring(0, ((tmp.length()) - 1));
        });
        Set<java.lang.String> subDirectPackage = new HashSet<java.lang.String>();
        for (Map.Entry<java.lang.String, java.util.Map<java.lang.Integer, java.lang.Boolean>> entry : _Instrumenting.lines.entrySet()) {
            if ((entry.getKey().substring(0, entry.getKey().lastIndexOf(".")).contains(commonPackage)) && ((entry.getKey().substring(0, entry.getKey().lastIndexOf(".")).split("\\.").length) > (commonPackage.split("\\.").length))) {
                subDirectPackage.add(String.format("%s.%s", commonPackage, entry.getKey().split("\\.")[commonPackage.split("\\.").length]));
            } 
            if ((entry.getKey().contains(commonPackage)) && (((entry.getKey().split("\\.").length) - 1) == (commonPackage.split("\\.").length))) {
                retMap.put(entry.getKey(), computeCoverageForClass(entry.getKey()));
            } 
        }
        for (String s : subDirectPackage) {
            getAllClasses(Optional.of(s), Optional.of(retMap));
        }
        return retMap;
    }

    private String getLongestCommonPrefix(String[] strings) {
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

    public static void run() {
        Application.launch();
    }

    public void hackTooltipStartTiming(Tooltip tooltip) {
        try {
            Field fieldBehavior = tooltip.getClass().getDeclaredField("BEHAVIOR");
            fieldBehavior.setAccessible(true);
            Object objBehavior = fieldBehavior.get(tooltip);
            Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
            fieldTimer.setAccessible(true);
            Timeline objTimer = ((Timeline)(fieldTimer.get(objBehavior)));
            objTimer.getKeyFrames().clear();
            objTimer.getKeyFrames().add(new javafx.animation.KeyFrame(new javafx.util.Duration(250)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

