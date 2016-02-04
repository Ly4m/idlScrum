package fil.iagl.idl.dao;

import org.apache.ibatis.annotations.Param;

import fil.iagl.idl.entite.Test;

public interface TestDao {
	void create(@Param("test") Test test);

	void changeState(@Param("id") Integer id, @Param("validate") Boolean validate);

	void delete(@Param("id") Integer id);

	Test getById(@Param("idTest") Integer idTest);

}
