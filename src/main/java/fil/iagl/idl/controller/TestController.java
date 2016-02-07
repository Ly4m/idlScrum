package fil.iagl.idl.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import fil.iagl.idl.entite.State;
import fil.iagl.idl.entite.Task;
import fil.iagl.idl.entite.Test;
import fil.iagl.idl.maven.MavenRunner;
import fil.iagl.idl.parser.Resultat;
import fil.iagl.idl.parser.XMLParser;
import fil.iagl.idl.service.TaskService;
import fil.iagl.idl.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	TestService testService;

	@Autowired
	TaskService taskService;

	@RequestMapping("/refresh")
	@ResponseBody
	public void test() {
		try {
			MavenRunner.cleanCompileTest(ScrumApplication.PATH_TO_POM);
			Resultat res = XMLParser.readSurefireReport(new File(ScrumApplication.PATH_TO_POM + "/target"));
			List<Test> testReport = res.getTests();

			List<Task> tasks = taskService.getAll();
			List<Test> toDelete = new ArrayList();
			for (Task task : tasks) {
				for (Test t : task.getTests()) {
					if (!testReport.contains(t)) {
						toDelete.add(t);
					}
				}
			}
			toDelete.forEach(t -> testService.delete(t.getId()));
			// Mise a jour des tests
			res.getTests().forEach(test -> testService.changeState(test.getId(), test.getValidate()));
			// détermine l'état des taches
			for (Task task : tasks) {
				if (task.getTests().isEmpty()) {
					taskService.changeState(task.getId(), State.TODO);
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
