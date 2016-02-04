package fil.iagl.idl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fil.iagl.idl.entite.Association;

public interface AssociationDao {

	void create(@Param("association") Association association);

	void delete(@Param("idAssociation") Integer idAssociation);

	List<Association> getAllForTask(@Param("idTask") Integer idTask);
}
