package ord.sid.dao;

import java.util.List;

import ord.sid.entities.Etudiant;


public interface UserRepo {
	public List<Etudiant> findByClass(String laclasse);
	
   
}
