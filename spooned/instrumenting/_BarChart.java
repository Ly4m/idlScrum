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
import javafx.scene.control.Button;
import fil.iagl.opl.rendu.two.insert.impl.CaseInsert;
import fil.iagl.opl.rendu.two.processors.CaseInsertTest;
import fil.iagl.opl.rendu.two.insert.impl.CatchInsert;
import fil.iagl.opl.rendu.two.processors.CatchInsertTest;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.paint.Color;
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
import java.io.FileOutputStream;
import org.apache.commons.io.FileUtils;
import spoon.reflect.visitor.Filter;
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
import java.util.Map;
import fil.iagl.opl.rendu.two.insert.impl.MethodInsert;
import fil.iagl.opl.rendu.two.processors.MethodInsertTest;
import fil.iagl.opl.rendu.two.samples.MethodSample;
import fil.iagl.opl.rendu.two.insert.NoInsertionFound;
import javafx.scene.chart.NumberAxis;
import java.io.ObjectOutputStream;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import java.util.function.Predicate;
import javafx.scene.shape.Rectangle;
import java.lang.annotation.Repeatable;
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
import fil.iagl.opl.rendu.two.insert.impl.TryInsert;
import fil.iagl.opl.rendu.two.processors.TryInsertTest;
import fil.iagl.opl.rendu.two.samples.TrySample;
import fil.iagl.opl.rendu.two.insert.impl.WhileInsert;
import fil.iagl.opl.rendu.two.processors.WhileInsertTest;
import fil.iagl.opl.rendu.two.samples.WhileSample;
import javafx.scene.chart.XYChart;

public class _BarChart extends Application {
    public static ObservableList<javafx.scene.chart.XYChart.Series<java.lang.String, java.lang.Number>> barChartData;

    private ArrayList<java.lang.String> classes;

    List<java.lang.String> currentList;

    List<javafx.scene.chart.XYChart.Data> dataList;

    BarChart chart;

    String current = "";

    @SuppressWarnings(value = { "unchecked" , "rawtypes" })
    private void init(Stage primaryStage) {
        currentList = new ArrayList<java.lang.String>();
        StackPane root = new StackPane();
        primaryStage.setScene(new javafx.scene.Scene(root));
        primaryStage.setTitle("CoCoSpoon");
        classes = new ArrayList<java.lang.String>();
        String tmp = _BarChart.getLongestCommonPrefix(_Instrumenting.lines.keySet().toArray(new String[_Instrumenting.lines.keySet().size()]));
        if ((tmp.charAt(((tmp.length()) - 1))) == '.') {
            tmp = tmp.substring(0, ((tmp.length()) - 1));
        } 
        classes.add(tmp);
        currentList.add(tmp);
        current = tmp;
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(classes));
        NumberAxis yAxis = new NumberAxis("Coverage (%)" , 0.0 , 100.0 , 5.0);
        dataList = new ArrayList<javafx.scene.chart.XYChart.Data>();
        XYChart.Data data = new XYChart.Data(classes.get(0) , 0);
        dataList.add(data);
        _BarChart.barChartData = FXCollections.observableArrayList(new XYChart.Series("Code coverage" , FXCollections.observableArrayList(dataList)));
        chart = new BarChart(xAxis , yAxis , _BarChart.barChartData , 25.0);
        chart.getXAxis().setAutoRanging(true);
        chart.setAnimated(false);
        root.getChildren().add(chart);
        Button bouton = new Button("..");
        root.getChildren().add(bouton);
        chart.setTitle("Real time code coverage");
        StackPane.setAlignment(bouton, javafx.geometry.Pos.TOP_RIGHT);
        Legend legend = ((Legend)(chart.lookup(".chart-legend")));
        Legend.LegendItem li1 = new Legend.LegendItem("Package" , new Rectangle(10 , 4 , Color.ORANGE));
        Legend.LegendItem li2 = new Legend.LegendItem("Class" , new Rectangle(10 , 4 , Color.rgb(101, 153, 255)));
        legend.getItems().setAll(li1, li2);
        for (String map : _Instrumenting.lines.keySet()) {
            ObservableMap<java.lang.Integer, java.lang.Boolean> observedMap = FXCollections.observableMap(_Instrumenting.lines.get(map));
            observedMap.addListener(new javafx.collections.MapChangeListener<java.lang.Integer, java.lang.Boolean>() {
                public void onChanged(javafx.collections.MapChangeListener.Change<? extends java.lang.Integer, ? extends java.lang.Boolean> changed) {
                    for (String s : currentList) {
                        for (XYChart.Data<java.lang.String, java.lang.Number> data : _BarChart.barChartData.get(0).getData()) {
                            if (s.contains(data.getXValue())) {
                                data.setYValue(display(s));
                            } 
                        }
                    }
                }
            });
            _Instrumenting.lines.put(map, observedMap);
        }
        chart.setOnMouseClicked(new javafx.event.EventHandler<javafx.event.Event>() {
            @Override
            public void handle(javafx.event.Event event) {
                for (XYChart.Series<java.lang.String, java.lang.Number> serie : _BarChart.barChartData) {
                    for (XYChart.Data<java.lang.String, java.lang.Number> item : serie.getData()) {
                        item.getNode().setOnMousePressed((javafx.event.Event event2) -> {
                            if (!(isClass(item.getXValue()))) {
                                retMap = new HashMap<java.lang.String, java.lang.Integer>();
                                current = item.getXValue();
                                Map<java.lang.String, java.lang.Integer> changeTo = getPackageResult(item.getXValue());
                                changeTo.remove(item.getXValue());
                                currentList = new ArrayList<java.lang.String>();
                                for (String s : changeTo.keySet()) {
                                    currentList.add(s);
                                }
                                refresh(changeTo);
                            } else {
                                javafx.application.Platform.runLater(new java.lang.Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            new instrumenting._FileView(String.format(((_Instrumenting.CURRENT_DIR) + "/src/main/java/%s.java"), item.getXValue().replaceAll("\\.", "/")) , item.getXValue()).start(new Stage());
                                        } catch (Exception e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                });
                            }
                        });
                    }
                }
            }
        });
        bouton.setOnMouseClicked(new javafx.event.EventHandler<javafx.event.Event>() {
            @Override
            public void handle(javafx.event.Event arg0) {
                retMap = new HashMap<java.lang.String, java.lang.Integer>();
                current = current.substring(0, current.lastIndexOf("."));
                Map<java.lang.String, java.lang.Integer> changeTo = getPackageResult(current);
                changeTo.remove(current);
                currentList = new ArrayList<java.lang.String>();
                for (String s : changeTo.keySet()) {
                    currentList.add(s);
                }
                refresh(changeTo);
            }
        });
    }

    private void refresh(Map<java.lang.String, java.lang.Integer> changeTo) {
        dataList.clear();
        classes.clear();
        _BarChart.barChartData.get(0).getData().clear();
        for (String s : changeTo.keySet()) {
            classes.add(s);
            XYChart.Data<java.lang.String, java.lang.Number> barTmp = new XYChart.Data<java.lang.String, java.lang.Number>();
            barTmp.setXValue(s);
            barTmp.setYValue(changeTo.get(s));
            _BarChart.barChartData.get(0).getData().add(barTmp);
            if (isClass(s)) {
                barTmp.getNode().setStyle("-fx-bar-fill: #6599FF;");
            } 
        }
    }

    public boolean isToRefresh(String key) {
        return currentList.contains(key);
    }

    private boolean isClass(String s) {
        return _Instrumenting.lines.keySet().contains(s);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    public Integer display(String className) {
        Float nbLineExecuted = 0.0F;
        Float nbLineTotal = 0.0F;
        for (Map.Entry<java.lang.String, java.util.Map<java.lang.Integer, java.lang.Boolean>> entry : _Instrumenting.lines.entrySet()) {
            if (entry.getKey().startsWith(className)) {
                for (boolean isExecuted : entry.getValue().values()) {
                    if (isExecuted) {
                        nbLineExecuted++;
                    } 
                }
                nbLineTotal += entry.getValue().size();
            } 
        }
        Float covergeRatio = nbLineExecuted / nbLineTotal;
        return Math.round((covergeRatio * 100));
    }

    public Integer displayForCLass(String className) {
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

    Map<java.lang.String, java.lang.Integer> retMap = new HashMap<java.lang.String, java.lang.Integer>();

    public Map<java.lang.String, java.lang.Integer> getPackageResult(String packageName) {
        String commonPackage;
        if (packageName == null) {
            commonPackage = _BarChart.getLongestCommonPrefix(_Instrumenting.lines.keySet().toArray(new String[_Instrumenting.lines.keySet().size()]));
            commonPackage = commonPackage.substring(0, ((commonPackage.length()) - 1));
        } else {
            commonPackage = packageName;
        }
        Set<java.lang.String> subDirectPackage = new HashSet<java.lang.String>();
        for (Map.Entry<java.lang.String, java.util.Map<java.lang.Integer, java.lang.Boolean>> entry : _Instrumenting.lines.entrySet()) {
            if ((entry.getKey().substring(0, entry.getKey().lastIndexOf(".")).contains(commonPackage)) && ((entry.getKey().substring(0, entry.getKey().lastIndexOf(".")).split("\\.").length) > (commonPackage.split("\\.").length))) {
                subDirectPackage.add(String.format("%s.%s", commonPackage, entry.getKey().split("\\.")[commonPackage.split("\\.").length]));
            } 
            if ((entry.getKey().contains(commonPackage)) && (((entry.getKey().split("\\.").length) - 1) == (commonPackage.split("\\.").length))) {
                retMap.put(entry.getKey(), displayForCLass(entry.getKey()));
            } 
        }
        for (String s : subDirectPackage) {
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
            retMap.put(s, Math.round((covergeRatio * 100)));
        }
        return retMap;
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

    public static void run() {
        Application.launch();
    }
}

