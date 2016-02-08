package fil.iagl.idl.entity.impl;


public class ConnectionServiceImpl implements fil.iagl.idl.entity.ConnectionService {
    @org.springframework.beans.factory.annotation.Autowired
    fil.iagl.idl.dao.UserDao userDao;

    public fil.iagl.idl.entite.User signIn(java.lang.String login, java.lang.String password) {
        return userDao.get(login, password);
    }
}

