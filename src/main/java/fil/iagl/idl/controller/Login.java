package fil.iagl.idl.controller;

import fil.iagl.idl.FormulaireRecherche;
import fil.iagl.idl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Login {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public
    @ResponseBody
    Boolean get(@RequestBody final FormulaireRecherche formulaireRecherche) {

        return formulaireRecherche.isCorrectlySet() && userService.get(formulaireRecherche.getLogin(), formulaireRecherche.getPassword()) != null;
    }

}
