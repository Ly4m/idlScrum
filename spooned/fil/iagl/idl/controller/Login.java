package fil.iagl.idl.controller;


@org.springframework.stereotype.Controller
public class Login {
    @org.springframework.beans.factory.annotation.Autowired
    fil.iagl.idl.service.UserService userService;

    @org.springframework.web.bind.annotation.RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.POST, value = "/search")
    @org.springframework.web.bind.annotation.ResponseBody
    public java.lang.Boolean get(@org.springframework.web.bind.annotation.RequestBody
    final fil.iagl.idl.FormulaireRecherche formulaireRecherche) {
        return (formulaireRecherche.isCorrectlySet()) && ((userService.get(formulaireRecherche.getLogin(), formulaireRecherche.getPassword())) != null);
    }
}

