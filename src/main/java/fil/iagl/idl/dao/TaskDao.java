package fil.iagl.idl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.idl.entite.Task;

public interface TaskDao {

	void create(@Param("task") Task task);

	void changeState(@Param("id") Integer id, @Param("state") Integer state);

	void delete(@Param("id") Integer id);

	void update(@Param("task") Task task);

	Task getById(@Param("idTask") Integer idTask);

	void deleteByIdStory(@Param("idStory") Integer idStory);

	List<Task> getByIdStory(@Param("id") Integer idStory);

	List<Task> getAll();

	Task getByName(@Param("taskName") String taskName);

	void linkToUser(@Param("taskId") Integer taskId, @Param("userId") Integer userId);

}
