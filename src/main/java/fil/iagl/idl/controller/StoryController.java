package fil.iagl.idl.controller;

import fil.iagl.idl.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/story" )
public class StoryController {

    @Autowired
    private StoryService storyService;

//    @RequestMapping( method = RequestMethod.GET , value = "/all" )
//    public List< Story > getAll() {
//
//    }
}
