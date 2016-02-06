package fil.iagl.idl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fil.iagl.idl.entite.Story;

@Service
public interface StoryService {

	public List<Story> getAll();

}
