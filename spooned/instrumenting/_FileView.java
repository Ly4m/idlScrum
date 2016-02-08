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
import javafx.scene.text.Text;
import fil.iagl.opl.rendu.two.insert.impl.TryInsert;
import fil.iagl.opl.rendu.two.processors.TryInsertTest;
import fil.iagl.opl.rendu.two.samples.TrySample;
import fil.iagl.opl.rendu.two.insert.impl.WhileInsert;
import fil.iagl.opl.rendu.two.processors.WhileInsertTest;
import fil.iagl.opl.rendu.two.samples.WhileSample;
import javafx.scene.chart.XYChart;

public class _FileView extends Application {
    private String path;

    private String classToDisplay;

    List<java.lang.String> lines = new ArrayList<java.lang.String>();

    public _FileView(String path ,String classToDisplay) {
        this.path = path;
        this.classToDisplay = classToDisplay;
    }

    public static void run() {
        Application.launch();
    }

    @Override
    public void init() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                lines.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        init();
        stage.setTitle(("Couverture de la classe " + (path)));
        ListView<java.lang.String> list = new ListView(FXCollections.observableArrayList(lines));
        list.setCellFactory(new javafx.util.Callback<javafx.scene.control.ListView<java.lang.String>, ListCell<java.lang.String>>() {
            @Override
            public ListCell<java.lang.String> call(ListView<java.lang.String> listView) {
                return new FruitFlowCell();
            }
        });
        list.setPrefSize(900, 600);
        Scene scene = new Scene(list);
        stage.setScene(scene);
        stage.show();
    }

    class FruitFlowCell extends ListCell<java.lang.String> {
        @Override
        protected void updateItem(String s, boolean empty) {
            super.updateItem(s, empty);
            if (!(isEmpty())) {
                setGraphic(createTextFlow(s));
                if ((getGraphic()) != null) {
                    setContentDisplay(javafx.scene.control.ContentDisplay.GRAPHIC_ONLY);
                } else {
                    setContentDisplay(javafx.scene.control.ContentDisplay.LEFT);
                }
            } 
        }

        private Node createTextFlow(String msg) {
            FlowPane flow = new FlowPane();
            Random r = new Random();
            int tmp = r.nextInt(2);
            Text text = new Text(msg);
            if ((_Instrumenting.lines.get(classToDisplay).get(((getIndex()) + 1))) == null) {
                flow.setStyle("-fx-background-color: #FFFFFF;");
            } else if (_Instrumenting.lines.get(classToDisplay).get(((getIndex()) + 1))) {
                flow.setStyle("-fx-background-color: #C0FFC0;");
            } else {
                flow.setStyle("-fx-background-color: #FFA0A0;");
            }
            flow.getChildren().add(text);
            return flow;
        }
    }
}

