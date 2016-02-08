package fil.iagl.idl.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.maven.shared.invoker.MavenInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import fil.iagl.idl.ScrumApplication;
import fil.iagl.idl.annotation.CorrespondingTask;
import fil.iagl.idl.entite.State;
import fil.iagl.idl.entite.Task;
import fil.iagl.idl.entite.Test;
import fil.iagl.idl.maven.MavenRunner;
import fil.iagl.idl.parser.Resultat;
import fil.iagl.idl.parser.XMLParser;
import fil.iagl.idl.service.AssociationService;
import fil.iagl.idl.service.TaskService;
import fil.iagl.idl.service.TestService;
import spoon.Launcher;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	TestService testService;

	@Autowired
	TaskService taskService;

	@Autowired
	AssociationService associationService;

	@RequestMapping("/refresh")
	@ResponseBody
	@CorrespondingTask(taskName = "yolo")
	public void test() {
		try {
			MavenRunner.cleanCompileTest(ScrumApplication.PATH_TO_POM);
			Resultat res = XMLParser.readSurefireReport(new File(ScrumApplication.PATH_TO_POM + "/target"));

			associationService.deleteAll();
			testService.deleteAll();
			res.getTests().forEach(t -> testService.create(t));
			// List<Test> oldTests = testService.getAll();
			//
			// List<Test> toAdd = new ArrayList<>();
			// toAdd.addAll(res.getTests().stream().filter(t -> {
			// for (Test ot : oldTests) {
			// if (t.getName().equals(ot.getName())) {
			// return false;
			// }
			// }
			// return true;
			// }).collect(Collectors.toList()));
			//
			// List<Test> toDelete = new ArrayList<>();
			//
			// toDelete.addAll(oldTests.stream().filter(t -> {
			// for (Test nt : res.getTests()) {
			// if (t.getName().equals(nt.getName())) {
			// return false;
			// }
			// }
			// return true;
			// }).collect(Collectors.toList()));
			//
			// toDelete.forEach(t ->
			// associationService.deleteForTestId(t.getId()));
			// toDelete.forEach(t -> testService.delete(t.getId()));
			//
			// toAdd.forEach(t -> testService.create(t));

			// Bind des tests avec les taches
			ScrumApplication.associationMap = new HashMap<String, List<String>>();
			String[] spoonArgs = { "-i", "C:/workspace/CoCoSpoon/src/main/java;C:/workspace/CoCoSpoon/src/test/java",
					"-p", "fil.iagl.idl.processor.AnnotationProcessor", "--source-classpath",
					"C:/workspace/CoCoSpoon/target/test-classes;C:/workspace/CoCoSpoon/target/classes;C:/Users/wokei/.m2/repository/fr/inria/gforge/spoon/spoon-core/4.4.1/spoon-core-4.4.1.jar;C:/Users/wokei/.m2/repository/org/eclipse/jdt/org.eclipse.jdt.core/3.12.0.v20150913-1717/org.eclipse.jdt.core-3.12.0.v20150913-1717.jar;C:/Users/wokei/.m2/repository/com/martiansoftware/jsap/2.1/jsap-2.1.jar;C:/Users/wokei/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar;C:/Users/wokei/.m2/repository/commons-io/commons-io/1.3.2/commons-io-1.3.2.jar;C:/Users/wokei/.m2/repository/org/apache/commons/commons-lang3/3.4/commons-lang3-3.4.jar;C:/Users/wokei/.m2/repository/junit/junit/3.8.2;C:/Users/wokei/.m2/repository/junit/junit/4.12/junit-4.12.jar;C:/Users/wokei/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar;C:/Users/wokei/.m2/repository/org/easytesting/fest-assert/1.4/fest-assert-1.4.jar;C:/Users/wokei/.m2/repository/org/easytesting/fest-util/1.1.6/fest-util-1.1.6.jar",
					"--with-imports" };

			try {
				Launcher.main(spoonArgs);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// associationService.deleteAll();
			ScrumApplication.associationMap.keySet().forEach(testName -> ScrumApplication.associationMap.get(testName)
					.forEach(taskName -> associationService.addByTestName(testName, taskName)));

			// Mise a jour des tests
			res.getTests().forEach(test -> testService.changeState(test.getId(), test.getValidate()));

			// détermine l'état des taches
			List<Task> tasks = taskService.getAll();

			for (Task task : tasks) {
				if (task.getTests().isEmpty()) {
					taskService.changeState(task.getId(), State.TODO);
				} else {
					Boolean isNotValid = task.getTests().stream().anyMatch(t -> !t.getValidate());

					if (isNotValid && task.getState().equals(State.DONE.getId())) {
						taskService.changeState(task.getId(), State.TEST_FAIL);
					} else if (isNotValid) {
						taskService.changeState(task.getId(), State.DOING);
					} else {
						taskService.changeState(task.getId(), State.DONE);
					}
				}

			}

		} catch (SAXException | IOException | ParserConfigurationException | MavenInvocationException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<Test> getTasks() {
		return testService.getAll();
	}

}
