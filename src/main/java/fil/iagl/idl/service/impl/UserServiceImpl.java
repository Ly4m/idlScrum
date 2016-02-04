package fil.iagl.idl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.idl.dao.UserDao;
import fil.iagl.idl.entite.User;
import fil.iagl.idl.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	
	@Override
	public User get(String login, String password) {
		if(login !=null && password !=null){
			return userDao.get(login, password);
		}
		return null;
	}

	@Override
	public void create(User user) {
		if(user !=null){
			userDao.create(user);
		}
	}

	@Override
	public User getById(Integer id) {
		if(id != null){
			return userDao.getById(id);
		}
		return null;
	}

}
