package fil.iagl.idl.controller;

import fil.iagl.idl.entite.Story;
import fil.iagl.idl.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/story")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Story> getAll() {
        return storyService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Story create(@RequestBody Story story) {
        if (story != null) {
            storyService.create(story);
        }
        return story;
    }
}
