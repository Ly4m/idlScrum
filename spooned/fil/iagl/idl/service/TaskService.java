package fil.iagl.idl.service;


@org.springframework.stereotype.Service
public interface TaskService {
    void create(fil.iagl.idl.entite.Task task);

    void changeState(java.lang.Integer id, fil.iagl.idl.entite.State state);

    void delete(java.lang.Integer id);

    void update(java.lang.Integer id, java.lang.String name, java.lang.String description);

    fil.iagl.idl.entite.Task getById(java.lang.Integer idTask);

    java.util.List<fil.iagl.idl.entite.Task> getAll();
}

