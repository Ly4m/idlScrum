package fil.iagl.idl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fil.iagl.idl.entite.Test;

@Service
public interface TestService {

	void create(Test test);

	void changeState(Integer id, Boolean validate);

	void deleteAll();

	Test getbyId(Integer id);

	List<Test> getAll();

	void delete(Integer id);

	Test getByName(String name);

}
