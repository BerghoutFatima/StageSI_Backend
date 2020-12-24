package ord.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ord.sid.entities.Projet;

public interface ProjetRepository extends JpaRepository<Projet,Long> {

	@Query("select p from Projet p where p.titre like :x and p.laclasse like :c and p.status like 1 ")
	public List<Projet> chercher(@Param("x")String mc,@Param("c")String laclasse );
	
	@Query("select p from Projet p where p.titre like :x and p.laclasse like :c and p.status like 0 ")
	public List<Projet> chercherNV(@Param("x")String mc,@Param("c")String laclasse );
	
	@Query("select p from Projet p where p.titre like :x and p.status like 1 ")
	public List<Projet> cherCher(@Param("x")String mc);
	
	@Query("select p from Projet p where p.status like 1 ")
	public List<Projet> listerProjetsV();
	
	@Query("select p from Projet p where p.status like 1 or p.status like 2 ")
	public List<Projet> listerProjetsEtudiantV();
	
	
	
}

