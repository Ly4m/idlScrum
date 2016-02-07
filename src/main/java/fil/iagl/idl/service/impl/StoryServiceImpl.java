package fil.iagl.idl.service.impl;

import fil.iagl.idl.dao.StoryDao;
import fil.iagl.idl.dao.TaskDao;
import fil.iagl.idl.entite.Story;
import fil.iagl.idl.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryDao storyDao;

    @Autowired
    private TaskDao taskDao;

    @Override
    public List<Story> getAll() {
        return storyDao.getAll();
    }

    @Override
    public void create(Story story) {
        storyDao.create(story);
    }

    @Override
    public void delete(Integer id) {

        storyDao.delete(id);
    }


}
