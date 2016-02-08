package fil.iagl.idl.controller;


@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping(value = "/task")
public class TaskController {
    @org.springframework.beans.factory.annotation.Autowired
    private fil.iagl.idl.service.TaskService taskService;

    @org.springframework.web.bind.annotation.RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.GET, value = "/all")
    public java.util.List<fil.iagl.idl.entite.Task> getTasks() {
        return taskService.getAll();
    }

    @org.springframework.web.bind.annotation.RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.GET, value = "/{id}")
    public fil.iagl.idl.entite.Task getTask(@org.springframework.web.bind.annotation.PathVariable(value = "id")
    java.lang.Integer id) {
        return taskService.getById(id);
    }

    @org.springframework.web.bind.annotation.RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.POST)
    public fil.iagl.idl.entite.Task create(@org.springframework.web.bind.annotation.RequestBody
    fil.iagl.idl.entite.Task task) {
        if (task != null) {
            taskService.create(task);
            return task;
        } 
        return null;
    }

    @org.springframework.web.bind.annotation.RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.DELETE, value = "/delete/{id}")
    public void delete(@org.springframework.web.bind.annotation.PathVariable(value = "idTask")
    final java.lang.Integer taskId) {
        if (taskId != null) {
            taskService.delete(taskId);
        } 
    }
}

