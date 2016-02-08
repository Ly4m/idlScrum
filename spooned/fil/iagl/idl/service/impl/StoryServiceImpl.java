package fil.iagl.idl.service.impl;


@org.springframework.stereotype.Service
public class StoryServiceImpl implements fil.iagl.idl.service.StoryService {
    @org.springframework.beans.factory.annotation.Autowired
    private fil.iagl.idl.dao.StoryDao storyDao;

    @org.springframework.beans.factory.annotation.Autowired
    private fil.iagl.idl.dao.TaskDao taskDao;

    @java.lang.Override
    public java.util.List<fil.iagl.idl.entite.Story> getAll() {
        return storyDao.getAll();
    }

    @java.lang.Override
    public void create(fil.iagl.idl.entite.Story story) {
        storyDao.create(story);
    }

    @java.lang.Override
    public void delete(java.lang.Integer id) {
        storyDao.delete(id);
    }
}

