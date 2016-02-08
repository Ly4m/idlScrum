package fil.iagl.idl.dao;


public interface TestDao {
    void create(@org.apache.ibatis.annotations.Param(value = "test")
    fil.iagl.idl.entite.Test test);

    void changeState(@org.apache.ibatis.annotations.Param(value = "id")
    java.lang.Integer id, @org.apache.ibatis.annotations.Param(value = "validate")
    java.lang.Boolean validate);

    void deleteAll();

    fil.iagl.idl.entite.Test getById(@org.apache.ibatis.annotations.Param(value = "idTest")
    java.lang.Integer idTest);

    java.util.List<fil.iagl.idl.entite.Test> getAll();

    void delete(@org.apache.ibatis.annotations.Param(value = "id")
    java.lang.Integer id);

    java.util.List<fil.iagl.idl.entite.Test> getByTaskId(@org.apache.ibatis.annotations.Param(value = "id")
    java.lang.Integer id);
}

