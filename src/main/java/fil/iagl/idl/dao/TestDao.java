package fil.iagl.idl.dao;

import fil.iagl.idl.entite.Test;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestDao {
	void create(@Param("test") Test test);

	void changeState(@Param("id") Integer id, @Param("validate") Boolean validate);

	void delete(@Param("id") Integer id);

	Test getById(@Param("idTest") Integer idTest);

	List<Test> getAll();

}
