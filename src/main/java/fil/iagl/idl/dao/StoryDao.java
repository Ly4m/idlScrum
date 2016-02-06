package fil.iagl.idl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.idl.entite.Story;

public interface StoryDao {

	Story getById(@Param("id") final Integer id);

	List<Story> getAll();
}
