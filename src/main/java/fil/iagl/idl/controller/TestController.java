package fil.iagl.idl.controller;

import fil.iagl.idl.entite.Test;
import fil.iagl.idl.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;


    @RequestMapping(method = RequestMethod.GET,  value = "/all")
    public List<Test> getTasks() {
        return testService.getAll();
    }

}
