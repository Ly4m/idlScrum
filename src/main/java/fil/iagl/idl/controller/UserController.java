package fil.iagl.idl.controller;

import fil.iagl.idl.entite.User;
import fil.iagl.idl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        userService.create(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<User> getAll() {

        return userService.getAll();

    }
}
