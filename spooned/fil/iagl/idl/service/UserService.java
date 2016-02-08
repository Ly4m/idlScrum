package fil.iagl.idl.service;


@org.springframework.stereotype.Service
public interface UserService {
    fil.iagl.idl.entite.User get(java.lang.String login, java.lang.String password);

    void create(fil.iagl.idl.entite.User user);

    fil.iagl.idl.entite.User getById(java.lang.Integer id);
}

