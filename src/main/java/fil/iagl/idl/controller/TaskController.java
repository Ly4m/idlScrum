package fil.iagl.idl.controller;

import fil.iagl.idl.entite.Task;
import fil.iagl.idl.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/task" )
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping( method = RequestMethod.GET , value = "/all")
    public List< Task > getTasks() {
        return taskService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Task getTask(  @PathVariable( "id" )Integer id){
        return taskService.getById(id);
    }

    @RequestMapping( method = RequestMethod.POST )
    public Task create( @RequestBody Task task ) {
        if ( task != null ) {
            taskService.create( task );
            return task;
        }
        return null;
    }

    @RequestMapping( method = RequestMethod.DELETE , value = "/delete/{id}" )
    public void delete( @PathVariable( "idTask" ) final Integer taskId) {
        if ( taskId != null ) {
            taskService.delete( taskId );
        }
    }

}
