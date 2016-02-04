package fil.iagl.idl.controller;

import fil.iagl.idl.entite.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Login {

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public @ResponseBody User signIn(@RequestParam String user, @RequestParam String password) {

        System.out.println(user + " " + password);

        return new User();
    }

}
