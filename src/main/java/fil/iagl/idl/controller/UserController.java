package fil.iagl.idl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.idl.FormulaireRecherche;
import fil.iagl.idl.entite.User;
import fil.iagl.idl.service.UserService;

@RestController
@RequestMapping( "/user" )
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping( method = RequestMethod.PUT )
    public User create( @RequestBody User user ) {
        userService.create( user );
        return user;
    }

    @RequestMapping( value = "/search" , method = RequestMethod.POST )
    public Boolean get( @ModelAttribute( "formulaireRecherche" ) final FormulaireRecherche formulaireRecherche) {

        if ( formulaireRecherche.isCorrectlySet() ) {
            return userService.get( formulaireRecherche.getLogin(), formulaireRecherche.getPassword() ) != null;
        }
        return false;
    }

}
