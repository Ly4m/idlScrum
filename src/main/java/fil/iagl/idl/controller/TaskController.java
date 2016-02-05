package fil.iagl.idl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.idl.entite.Task;
import fil.iagl.idl.service.TaskService;

@RestController
@RequestMapping("/taskController")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Task> getTasks() {
		return taskService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Task create(@RequestBody Task task) {
		if (task != null) {
			taskService.create(task);
			return task;
		}
		return null;
	}
}
