package fil.iagl.idl.service.impl;


@org.springframework.stereotype.Service
public class UserServiceImpl implements fil.iagl.idl.service.UserService {
    @org.springframework.beans.factory.annotation.Autowired
    fil.iagl.idl.dao.UserDao userDao;

    @java.lang.Override
    public fil.iagl.idl.entite.User get(java.lang.String login, java.lang.String password) {
        if ((login != null) && (password != null)) {
            return userDao.get(login, password);
        } 
        return null;
    }

    @java.lang.Override
    public void create(fil.iagl.idl.entite.User user) {
        if (user != null) {
            userDao.create(user);
        } 
    }

    @java.lang.Override
    public fil.iagl.idl.entite.User getById(java.lang.Integer id) {
        if (id != null) {
            return userDao.getById(id);
        } 
        return null;
    }
}

