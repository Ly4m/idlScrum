package fil.iagl.idl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fil.iagl.idl.FormulaireRecherche;
import fil.iagl.idl.entite.User;
import fil.iagl.idl.service.UserService;

@Controller
public class Login {

    @Autowired
    UserService userService;

    @RequestMapping( value = "/signin" , method = RequestMethod.POST )
    public @ResponseBody User signIn( @RequestParam String user , @RequestParam String password ) {

        System.out.println( user + " " + password );

        return new User();
    }

    @RequestMapping( value = "/search" , method = RequestMethod.POST )
    public Boolean get( @ModelAttribute( "formulaireRecherche" ) final FormulaireRecherche formulaireRecherche) {

        if ( formulaireRecherche.isCorrectlySet() ) {
            return userService.get( formulaireRecherche.getLogin(), formulaireRecherche.getPassword() ) != null;
        }
        return false;
    }

}
