package ord.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ord.sid.entities.Etudiant;
@Repository
@Transactional
public class EtudiantController implements UserRepo{
	@PersistenceContext
	private EntityManager em;

	public List<Etudiant> findByClass(String classe) {
	
		Query req = em.createQuery("select e from Etudiant e where e.laclasse like :x");
		req.setParameter("x", classe);
		return req.getResultList();
	}
	
	public List<Etudiant> findByEmail(String val) {
		Query req = em.createQuery("select e from Etudiant e where e.email like :x ");
		req.setParameter("x", val);
		return req.getResultList();
	}
	

}


