package ord.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import ord.sid.entities.Projet;

@Repository
@Transactional
public class ProjetController implements ProjectRepo{

	@PersistenceContext
	private EntityManager em;

	//les prjts validés
	public List<Projet> findByClass(String classe) {
	
		Query req = em.createQuery("select p from Projet p where p.laclasse like :x and p.status like 1");
		req.setParameter("x", classe);
		return req.getResultList();
	}
	//les prjts pas encore validés par le CPF
	public List<Projet> findNVByClass(String classe) {
		
		Query r = em.createQuery("select p from Projet p where p.laclasse like :x and p.status like 0");
		r.setParameter("x", classe);
		return r.getResultList();
	}

}





