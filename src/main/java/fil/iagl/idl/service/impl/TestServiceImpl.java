package fil.iagl.idl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.idl.dao.TestDao;
import fil.iagl.idl.entite.Test;
import fil.iagl.idl.service.TestService;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	TestDao testDao;
	
	@Override
	public void create(Test test) {
		if(test != null){
			testDao.create(test);
		}
	}

	@Override
	public void changeState(Integer id, Boolean validate) {
		if(id !=null && validate != null){
			testDao.changeState(id, validate);
		}
	}

	@Override
	public void delete(Integer id) {
		if(id != null ){
			testDao.delete(id);
		}
	}

	@Override
	public Test getbyId(Integer id) {
		if(id !=null){
			testDao.getById(id);
		}
		return null;
	}

	@Override
	public List<Test> getAll() {
		return testDao.getAll();
	}

}
