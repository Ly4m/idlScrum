package fil.iagl.idl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fil.iagl.idl.entite.Story;
import fil.iagl.idl.service.StoryService;

@RestController
@RequestMapping( "/story" )
public class StoryController {

    @Autowired
    private StoryService storyService;

    @RequestMapping( method = RequestMethod.GET , value = "/all" )
    public List< Story > getAll() {

    }
}
