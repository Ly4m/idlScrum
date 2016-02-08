package fil.iagl.idl.service;

import fil.iagl.idl.entite.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

	User get(String login, String password);
	
	void create(User user);
	
	User getById(Integer id);

	List<User> getAll();
}
