package fil.iagl.idl.controller;


@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping(value = "/user")
public class UserController {
    @org.springframework.beans.factory.annotation.Autowired
    private fil.iagl.idl.service.UserService userService;

    @org.springframework.web.bind.annotation.RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.PUT)
    public fil.iagl.idl.entite.User create(@org.springframework.web.bind.annotation.RequestBody
    fil.iagl.idl.entite.User user) {
        userService.create(user);
        return user;
    }
}

