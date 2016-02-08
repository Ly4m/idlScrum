package fil.iagl.idl.dao;


public interface TaskDao {
    void create(@org.apache.ibatis.annotations.Param(value = "task")
    fil.iagl.idl.entite.Task task);

    void changeState(@org.apache.ibatis.annotations.Param(value = "id")
    java.lang.Integer id, @org.apache.ibatis.annotations.Param(value = "state")
    java.lang.Integer state);

    void delete(@org.apache.ibatis.annotations.Param(value = "id")
    java.lang.Integer id);

    void update(@org.apache.ibatis.annotations.Param(value = "id")
    java.lang.Integer id, @org.apache.ibatis.annotations.Param(value = "name")
    java.lang.String name, @org.apache.ibatis.annotations.Param(value = "description")
    java.lang.String description);

    fil.iagl.idl.entite.Task getById(@org.apache.ibatis.annotations.Param(value = "idTask")
    java.lang.Integer idTask);

    void deleteByIdStory(@org.apache.ibatis.annotations.Param(value = "idStory")
    java.lang.Integer idStory);

    java.util.List<fil.iagl.idl.entite.Task> getByIdStory(@org.apache.ibatis.annotations.Param(value = "id")
    java.lang.Integer idStory);

    java.util.List<fil.iagl.idl.entite.Task> getAll();
}

