package fil.iagl.idl.dao;


public interface UserDao {
    fil.iagl.idl.entite.User get(@org.apache.ibatis.annotations.Param(value = "login")
    java.lang.String login, @org.apache.ibatis.annotations.Param(value = "password")
    java.lang.String password);

    void create(@org.apache.ibatis.annotations.Param(value = "user")
    fil.iagl.idl.entite.User user);

    fil.iagl.idl.entite.User getById(@org.apache.ibatis.annotations.Param(value = "id")
    java.lang.Integer id);
}

