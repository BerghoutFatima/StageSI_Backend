package ord.sid.web;

import ord.sid.entities.Etudiant;
import ord.sid.entities.Projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import ord.sid.dao.ProjetController;
import ord.sid.dao.ProjetRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@RestController
@CrossOrigin("*") // pour autoriser les requettes http de n'importe quelle domaine(*) de recuperer les donnees

public class ProjetRestService {

	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private ProjetController projetController;

	//les methodes a utiliser // @RequestMapping pour acceder a la methode via une requete http
	
	//lister projets
	@RequestMapping(value="/listerProjets",method=RequestMethod.GET)
	public List<Projet> listerProjets() {
		return  projetRepository.findAll();
	}
	
	
	
	//lister projets validés
		@RequestMapping(value="/listerProjetsvalides",method=RequestMethod.GET)
		public List<Projet> listerProjetsV() {
			return  projetRepository.listerProjetsV();
		}
		
		//lister projets validés
		@RequestMapping(value="/listerProjetsvalidesEtudiant",method=RequestMethod.GET)
		public List<Projet> listerProjetsEtudiantV() {
			return  projetRepository.listerProjetsEtudiantV();
		}
		
	
	//lister Projets validés by class
	@RequestMapping(value="/listerProjetParClasse/{vall}",method=RequestMethod.GET)
		public List<Projet> findByClass(@PathVariable String vall){
			return projetController.findByClass(vall);
		}
	
	//lister Projets not yet valid by class
		@RequestMapping(value="/listerProjetNVParClasse/{vall}",method=RequestMethod.GET)
			public List<Projet> findNVByClass(@PathVariable String vall){
				return projetController.findNVByClass(vall);
			}
		
		//Chercher 1 projet parmi tous les projets validés
		@RequestMapping(value="/chercherProjet",method=RequestMethod.GET)
			public List<Projet> cherCher(
					@RequestParam(name="mc", defaultValue="") String mc)
					 {
				return projetRepository.cherCher("%"+ mc +"%");
			}
		
	//Chercher projet validé dans search-bar
	@RequestMapping(value="/chercherProjets",method=RequestMethod.GET)
		public List<Projet> chercher(
				@RequestParam(name="mc", defaultValue="") String mc,@RequestParam(name="laclasse", defaultValue="") String laclasse)
				 {
			return projetRepository.chercher("%"+ mc +"%",laclasse);
		}
	
	//Chercher projet non validé dans search-bar
		@RequestMapping(value="/chercherProjetsNV",method=RequestMethod.GET)
			public List<Projet> chercherNV(
					@RequestParam(name="mc", defaultValue="") String mc,@RequestParam(name="laclasse", defaultValue="") String laclasse)
					 {
				return projetRepository.chercherNV("%"+ mc +"%",laclasse);
			}
	
	//consulter projet
	@RequestMapping(value="/detailsProjet/{id}",method=RequestMethod.GET)
	public Optional<Projet> detailsProjet(@PathVariable Long id){
		return projetRepository.findById(id);
	}
	
	//ajouter projet
	@RequestMapping(value="/ajouterProjet",method=RequestMethod.POST)
	public Projet ajouterProjet(@RequestBody Projet p) {
		return projetRepository.save(p);
	}
	
	
	//supprimer projet
	@RequestMapping(value="/supprimerProjets/{id}",method=RequestMethod.DELETE)
	public boolean supprimerProjet(@PathVariable Long id) {
		projetRepository.deleteById(id);
		return true;
	}
	
	//modifier projet
	@RequestMapping(value="/updateProjets/{id}",method=RequestMethod.PUT)
	public Projet modifierProjet(@PathVariable(name="id") Long id,@RequestBody Projet p) {
		p.setId(id);
		return projetRepository.save(p);
	}
	
	
}
