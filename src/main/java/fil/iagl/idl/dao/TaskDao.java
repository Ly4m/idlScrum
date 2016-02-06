package fil.iagl.idl.dao;

import fil.iagl.idl.entite.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskDao {

	void create(@Param("task") Task task);

	void changeState(@Param("id") Integer id, @Param("state") Integer state);

	void delete(@Param("id") Integer id);

	void update(@Param("id") Integer id, @Param("name") String name, @Param("description") String description);

	Task getById(@Param("idTask") Integer idTask);

	List<Task> getByIdStory(@Param("id")Integer idStory);

	List<Task> getAll();
}
