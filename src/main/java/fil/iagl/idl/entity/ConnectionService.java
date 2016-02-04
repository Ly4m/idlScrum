package fil.iagl.idl.entity;

import fil.iagl.idl.entite.User;

/**
 * Created by willl on 03/02/2016.
 */
public interface ConnectionService {

    public User signIn(String login, String password);

}
