package fil.iagl.idl.controller;

import fil.iagl.idl.ScrumApplication;
import fil.iagl.idl.entite.State;
import fil.iagl.idl.entite.Task;
import fil.iagl.idl.entite.Test;
import fil.iagl.idl.maven.MavenRunner;
import fil.iagl.idl.parser.Resultat;
import fil.iagl.idl.parser.XMLParser;
import fil.iagl.idl.service.AssociationService;
import fil.iagl.idl.service.TaskService;
import fil.iagl.idl.service.TestService;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	public void test() {
		try {
			MavenRunner.cleanCompileTest(ScrumApplication.PATH_TO_POM);
			Resultat res = XMLParser.readSurefireReport(new File(ScrumApplication.PATH_TO_POM + "/target"));

			List<Test> oldTests = testService.getAll();

			List<Test> toAdd = new ArrayList<>();
			toAdd.addAll(res.getTests().stream().filter(t -> !oldTests.contains(t)).collect(Collectors.toList()));

			List<Test> toDelete = new ArrayList<>();
			toDelete.addAll(oldTests.stream().filter(t -> !res.getTests().contains(t)).collect(Collectors.toList()));

			toDelete.forEach(t -> associationService.deleteForTestId(t.getId()));
			toDelete.forEach(t -> testService.delete(t.getId()));
			toAdd.forEach(t -> testService.create(t));

			// Mise a jour des tests
			res.getTests().forEach(test -> testService.changeState(test.getId(), test.getValidate()));

			// détermine l'état des taches
			List<Task> tasks = taskService.getAll();

			for (Task task : tasks) {
				if (task.getTests().isEmpty()) {
					taskService.changeState(task.getId(), State.TODO);
				} else {
					Boolean isValid = task.getTests().stream().anyMatch(t -> !t.getValidate());

					if (isValid) {
						taskService.changeState(task.getId(), State.DONE);
					} else if (task.getState().equals(State.DONE)) {
						taskService.changeState(task.getId(), State.TEST_FAIL);
					} else {
						taskService.changeState(task.getId(), State.DOING);
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
