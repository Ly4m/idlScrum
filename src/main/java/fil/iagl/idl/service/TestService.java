package fil.iagl.idl.service;

import fil.iagl.idl.entite.Test;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {

	void create(Test test);
	
	void changeState(Integer id, Boolean validate);
	
	void delete(Integer id);
	
	Test getbyId(Integer id);

	List<Test> getAll();
	
}
