package fil.iagl.idl.controller;


@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping(value = "/story")
public class StoryController {
    @org.springframework.beans.factory.annotation.Autowired
    private fil.iagl.idl.service.StoryService storyService;

    @org.springframework.web.bind.annotation.RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.GET, value = "/all")
    public java.util.List<fil.iagl.idl.entite.Story> getAll() {
        return storyService.getAll();
    }

    @org.springframework.web.bind.annotation.RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.POST)
    public fil.iagl.idl.entite.Story create(@org.springframework.web.bind.annotation.RequestBody
    fil.iagl.idl.entite.Story story) {
        if (story != null) {
            storyService.create(story);
        } 
        return story;
    }

    @org.springframework.web.bind.annotation.RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.DELETE, value = "/delete/{id}")
    public java.lang.Integer delete(@org.springframework.web.bind.annotation.PathVariable(value = "id")
    final java.lang.Integer id) {
        if (id != null) {
            storyService.delete(id);
        } 
        return id;
    }
}

