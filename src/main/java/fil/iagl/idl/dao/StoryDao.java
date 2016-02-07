package fil.iagl.idl.dao;

import fil.iagl.idl.entite.Story;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoryDao {

    Story getById(@Param("id") final Integer id);

    void create(@Param("story") Story story);

    void delete(@Param("id") final Integer id);

    List<Story> getAll();
}
