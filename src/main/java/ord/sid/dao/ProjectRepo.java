package ord.sid.dao;

import java.util.List;

import ord.sid.entities.Projet;

public interface ProjectRepo {

	public List<Projet> findByClass(String laclasse);
}



