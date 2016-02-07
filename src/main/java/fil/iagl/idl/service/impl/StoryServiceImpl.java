package fil.iagl.idl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.iagl.idl.dao.StoryDao;
import fil.iagl.idl.entite.Story;
import fil.iagl.idl.service.StoryService;

@Service
public class StoryServiceImpl implements StoryService {

	@Autowired
	StoryDao storyDao;

	@Override
	public List<Story> getAll() {
		return storyDao.getAll();
	}

	@Override
	public void create(Story story) {
		storyDao.create(story);
	}

}
