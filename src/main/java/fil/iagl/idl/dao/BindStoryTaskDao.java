package fil.iagl.idl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.idl.entite.BindStoryTask;

public interface BindStoryTaskDao {

	List<BindStoryTask> getAllByIdStory(@Param("id") final Integer id);
}
