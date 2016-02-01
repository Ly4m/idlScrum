package fil.iagl.idl.dao;

import org.apache.ibatis.annotations.Param;

import fil.iagl.idl.entite.User;

public interface UserDao {

	User get(@Param("login") String login, @Param("password") String password);

	void create(@Param("user") User user);

	User getById(@Param("id") Integer id);
}
