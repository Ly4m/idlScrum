package fil.iagl.idl.service;


@org.springframework.stereotype.Service
public interface AssociationService {
    void create(fil.iagl.idl.entite.Association association);

    void delete(java.lang.Integer idAssociation);

    java.util.List<fil.iagl.idl.entite.Association> getAllForTask(java.lang.Integer idTask);

    void deleteForTestId(java.lang.Integer idTest);
}

