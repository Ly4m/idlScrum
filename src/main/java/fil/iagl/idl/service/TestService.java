package fil.iagl.idl.service;

import org.springframework.stereotype.Service;

import fil.iagl.idl.entite.Test;

@Service
public interface TestService {

	void create(Test test);
	
	void changeState(Integer id, Boolean validate);
	
	void delete(Integer id);
	
	Test getbyId(Integer id);
	
}
