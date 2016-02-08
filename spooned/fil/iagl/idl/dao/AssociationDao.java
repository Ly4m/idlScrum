package fil.iagl.idl.dao;


public interface AssociationDao {
    void create(@org.apache.ibatis.annotations.Param(value = "association")
    fil.iagl.idl.entite.Association association);

    void delete(@org.apache.ibatis.annotations.Param(value = "idAssociation")
    java.lang.Integer idAssociation);

    java.util.List<fil.iagl.idl.entite.Association> getAllForTask(@org.apache.ibatis.annotations.Param(value = "idTask")
    java.lang.Integer idTask);

    void deleteForTestId(@org.apache.ibatis.annotations.Param(value = "idTest")
    java.lang.Integer idTest);
}

