package fil.iagl.idl.controller;

import fil.iagl.idl.entite.Story;
import fil.iagl.idl.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
    public Integer delete(@PathVariable("id")final Integer id) {
        if (id != null) {
            storyService.delete(id);
        }
        return id;
    }
}
