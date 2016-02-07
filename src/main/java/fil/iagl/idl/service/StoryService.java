package fil.iagl.idl.service;

import fil.iagl.idl.entite.Story;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoryService {

	List<Story> getAll();

	void create(Story story);

}
