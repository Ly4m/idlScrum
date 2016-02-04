package fil.iagl.idl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fil.iagl.idl.entite.Association;

@Service
public interface AssociationService {
	void create(Association association);
	void delete(Integer idAssociation);
	List<Association> getAllForTask(Integer idTask);
}
