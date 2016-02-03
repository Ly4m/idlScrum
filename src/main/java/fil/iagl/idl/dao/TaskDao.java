package fil.iagl.idl.dao;

import org.apache.ibatis.annotations.Param;

import fil.iagl.idl.entite.Task;

public interface TaskDao {

	void create(@Param("name") String name, @Param("description") String description);

	void changeState(@Param("id") Integer id, @Param("state") Integer state);

	void delete(@Param("id") Integer id);

	void update(@Param("id") Integer id, @Param("name") String name, @Param("description") String description);

	Task getById(@Param("idTask") Integer idTask);
}
