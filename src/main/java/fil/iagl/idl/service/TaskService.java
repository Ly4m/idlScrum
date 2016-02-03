package fil.iagl.idl.service;

import org.springframework.stereotype.Service;

import fil.iagl.idl.entite.State;
import fil.iagl.idl.entite.Task;

@Service
public interface TaskService {
	
	void create(Task task);
	
	void changeState(Integer id, State state);
	
	void delete(Integer id);
	
	void update(Integer id, String name, String description);
	
	Task getById(Integer idTask);
}
