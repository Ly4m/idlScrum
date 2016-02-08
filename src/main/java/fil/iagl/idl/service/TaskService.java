package fil.iagl.idl.service;

import fil.iagl.idl.entite.State;
import fil.iagl.idl.entite.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

	void create(Task task);

	void changeState(Integer id, State state);

	void delete(Integer id);

	void update(Task task);

	Task getById(Integer idTask);

	List<Task> getAll();

	void LinkToUser(Integer taskId, Integer userId);
}
