package fil.iagl.idl.service;


@org.springframework.stereotype.Service
public interface TestService {
    void create(fil.iagl.idl.entite.Test test);

    void changeState(java.lang.Integer id, java.lang.Boolean validate);

    void deleteAll();

    fil.iagl.idl.entite.Test getbyId(java.lang.Integer id);

    java.util.List<fil.iagl.idl.entite.Test> getAll();

    void delete(java.lang.Integer id);
}

