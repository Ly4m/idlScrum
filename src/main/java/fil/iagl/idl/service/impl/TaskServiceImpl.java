package fil.iagl.idl.service.impl;

import fil.iagl.idl.dao.TaskDao;
import fil.iagl.idl.entite.State;
import fil.iagl.idl.entite.Task;
import fil.iagl.idl.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;

	@Override
	public void create(Task task) {
		if (task != null) {
			taskDao.create(task);
		}
	}

	@Override
	public void changeState(Integer id, State state) {
		if (id != null && state != null) {
			taskDao.changeState(id, state.getId());
		}
	}

	@Override
	public void delete(Integer id) {
		if (id != null) {
			taskDao.delete(id);
		}
	}

	@Override
	public void update(Task task) {
		if (task != null) {
			taskDao.update(task);
		}
	}

	@Override
	public Task getById(Integer idTask) {
		if (idTask != null) {
			return taskDao.getById(idTask);
		}
		return null;
	}

	@Override
	public List<Task> getAll() {
		return taskDao.getAll();
	}

	@Override
	public void LinkToUser(Integer taskId, Integer userId) {
		taskDao.linkToUser(taskId, userId);
	}

}
