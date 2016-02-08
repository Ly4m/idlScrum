package fil.iagl.idl.service.impl;


@org.springframework.stereotype.Service
public class AssociationServiceImpl implements fil.iagl.idl.service.AssociationService {
    @org.springframework.beans.factory.annotation.Autowired
    fil.iagl.idl.dao.AssociationDao associationDao;

    @java.lang.Override
    public void create(fil.iagl.idl.entite.Association association) {
        if (association != null) {
            associationDao.create(association);
        } 
    }

    @java.lang.Override
    public void delete(java.lang.Integer idAssociation) {
        if (idAssociation != null) {
            associationDao.delete(idAssociation);
        } 
    }

    @java.lang.Override
    public java.util.List<fil.iagl.idl.entite.Association> getAllForTask(java.lang.Integer idTask) {
        if (idTask != null) {
            return associationDao.getAllForTask(idTask);
        } 
        return null;
    }

    @java.lang.Override
    public void deleteForTestId(java.lang.Integer idTest) {
        associationDao.deleteForTestId(idTest);
    }
}

