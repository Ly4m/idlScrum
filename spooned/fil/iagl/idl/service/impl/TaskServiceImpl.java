package fil.iagl.idl.service.impl;


@org.springframework.stereotype.Service
public class TaskServiceImpl implements fil.iagl.idl.service.TaskService {
    @org.springframework.beans.factory.annotation.Autowired
    private fil.iagl.idl.dao.TaskDao taskDao;

    @java.lang.Override
    public void create(fil.iagl.idl.entite.Task task) {
        if (task != null) {
            taskDao.create(task);
        } 
    }

    @java.lang.Override
    public void changeState(java.lang.Integer id, fil.iagl.idl.entite.State state) {
        if ((id != null) && (state != null)) {
            taskDao.changeState(id, state.getId());
        } 
    }

    @java.lang.Override
    public void delete(java.lang.Integer id) {
        if (id != null) {
            taskDao.delete(id);
        } 
    }

    @java.lang.Override
    public void update(java.lang.Integer id, java.lang.String name, java.lang.String description) {
        if (((id != null) && (name != null)) && (description != null)) {
            taskDao.update(id, name, description);
        } 
    }

    @java.lang.Override
    public fil.iagl.idl.entite.Task getById(java.lang.Integer idTask) {
        if (idTask != null) {
            return taskDao.getById(idTask);
        } 
        return null;
    }

    @java.lang.Override
    public java.util.List<fil.iagl.idl.entite.Task> getAll() {
        return taskDao.getAll();
    }
}

