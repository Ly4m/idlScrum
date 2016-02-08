package fil.iagl.idl.service;


@org.springframework.stereotype.Service
public interface StoryService {
    java.util.List<fil.iagl.idl.entite.Story> getAll();

    void create(fil.iagl.idl.entite.Story story);

    void delete(java.lang.Integer id);
}

