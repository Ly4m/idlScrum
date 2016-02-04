package fil.iagl.idl.entity.impl;

import fil.iagl.idl.dao.UserDao;
import fil.iagl.idl.entite.User;
import fil.iagl.idl.entity.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by willl on 03/02/2016.
 */
public class ConnectionServiceImpl implements ConnectionService{

    @Autowired
    UserDao userDao;

    public User signIn(String login, String password) {

        return userDao.get(login, password);

    }

}
