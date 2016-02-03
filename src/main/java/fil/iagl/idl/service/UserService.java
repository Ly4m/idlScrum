package fil.iagl.idl.service;

import org.springframework.stereotype.Service;

import fil.iagl.idl.entite.User;

@Service
public interface UserService {

	User get(String login, String password);
	
	void create(User user);
	
	User getById(Integer id);
}
