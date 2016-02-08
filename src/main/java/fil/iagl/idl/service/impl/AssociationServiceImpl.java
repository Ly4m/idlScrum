package fil.iagl.idl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.idl.dao.AssociationDao;
import fil.iagl.idl.dao.TaskDao;
import fil.iagl.idl.dao.TestDao;
import fil.iagl.idl.entite.Association;
import fil.iagl.idl.entite.Task;
import fil.iagl.idl.entite.Test;
import fil.iagl.idl.service.AssociationService;

@Service
public class AssociationServiceImpl implements AssociationService {
	@Autowired
	AssociationDao associationDao;

	@Autowired
	TestDao testDao;

	@Autowired
	TaskDao taskDao;

	@Override
	public void create(Association association) {
		if (association != null) {
			associationDao.create(association);
		}
	}

	@Override
	public void delete(Integer idAssociation) {
		if (idAssociation != null) {
			associationDao.delete(idAssociation);
		}
	}

	@Override
	public List<Association> getAllForTask(Integer idTask) {
		if (idTask != null) {
			return associationDao.getAllForTask(idTask);
		}
		return null;
	}

	@Override
	public void deleteForTestId(Integer idTest) {
		associationDao.deleteForTestId(idTest);
	}

	@Override
	public void addByTestName(String testName, String taskName) {
		Test test = testDao.getByName(testName);
		Task task = taskDao.getByName(taskName);
		Association association = new Association();
		association.setTask(task);
		association.setTest(test);
		associationDao.create(association);
	}

}
