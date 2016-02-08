package fil.iagl.idl.service.impl;


@org.springframework.stereotype.Service
public class TestServiceImpl implements fil.iagl.idl.service.TestService {
    @org.springframework.beans.factory.annotation.Autowired
    fil.iagl.idl.dao.TestDao testDao;

    @java.lang.Override
    public void create(fil.iagl.idl.entite.Test test) {
        if (test != null) {
            testDao.create(test);
        } 
    }

    @java.lang.Override
    public void changeState(java.lang.Integer id, java.lang.Boolean validate) {
        if ((id != null) && (validate != null)) {
            testDao.changeState(id, validate);
        } 
    }

    @java.lang.Override
    public void deleteAll() {
        testDao.deleteAll();
    }

    @java.lang.Override
    public fil.iagl.idl.entite.Test getbyId(java.lang.Integer id) {
        if (id != null) {
            testDao.getById(id);
        } 
        return null;
    }

    @java.lang.Override
    public java.util.List<fil.iagl.idl.entite.Test> getAll() {
        return testDao.getAll();
    }

    @java.lang.Override
    public void delete(java.lang.Integer id) {
        testDao.delete(id);
    }
}

