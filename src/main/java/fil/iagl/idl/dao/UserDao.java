package fil.iagl.idl.dao;

import fil.iagl.idl.entite.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

	List<User> getAll();

	User get(@Param("login") String login, @Param("password") String password);

	void create(@Param("user") User user);

	User getById(@Param("id") Integer id);
}
