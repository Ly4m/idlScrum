package fil.iagl.idl.dao;


public interface StoryDao {
    fil.iagl.idl.entite.Story getById(@org.apache.ibatis.annotations.Param(value = "id")
    final java.lang.Integer id);

    void create(@org.apache.ibatis.annotations.Param(value = "story")
    fil.iagl.idl.entite.Story story);

    void delete(@org.apache.ibatis.annotations.Param(value = "id")
    final java.lang.Integer id);

    java.util.List<fil.iagl.idl.entite.Story> getAll();
}

