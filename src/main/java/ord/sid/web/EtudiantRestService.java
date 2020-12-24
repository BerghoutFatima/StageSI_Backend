package ord.sid.web;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ord.sid.dao.EtudiantController;
import ord.sid.dao.EtudiantRepository;
import ord.sid.entities.Etudiant;
import ord.sid.entities.Projet;


@RestController
@CrossOrigin("*")
public class EtudiantRestService  {
	
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private EtudiantController etudiantController;
	
	
	
	//lister etudiants
		@RequestMapping(value="/listerEtudiants",method=RequestMethod.GET)
		public List<Etudiant> listerEtudiants() {
			return etudiantRepository.findAll();
		}
	//lister etudiants by class
		@RequestMapping(value="/listerEtudiantsParClasse/{vall}",method=RequestMethod.GET)
		public List<Etudiant> findByClass(@PathVariable String vall){
			return etudiantController.findByClass(vall);
		}
	
	//ajouter etudiant
		@RequestMapping(value="/ajouterEtudiant",method=RequestMethod.POST)
		public Etudiant ajouterEtudiant(@RequestBody Etudiant e) {
			return etudiantRepository.save(e);
		}
	
		
		@RequestMapping(value="/trouverEtudiant",method=RequestMethod.GET)
		public List<Etudiant> findByUsernameOrEmail(
				@RequestParam(name="un", defaultValue="") String un,@RequestParam(name="email", defaultValue="") String email)
				 {
			return etudiantRepository.findByUsernameOrEmail(un,email);
			
		}
		
		//trouver l edt by username
		@RequestMapping(value="/trouverEtudiantByUsername",method=RequestMethod.GET)
		public List<Etudiant> findByUsername(@RequestParam(name="un", defaultValue="") String un)
				 {
			return etudiantRepository.findByUsername(un);
			
		}
		
		//trouver l'etudiant par son login ( email & pwd)
		
		@RequestMapping(value="/trouverEtudiantParLogin",method=RequestMethod.GET)
		public List<Etudiant> findByUsernameAndPwd(
				@RequestParam(name="email", defaultValue="") String email,@RequestParam(name="password", defaultValue="") String password)
				 {
			return etudiantRepository.findByUsernameAndPwd(email,password);
				 }
	//chercher  etudiant by email
			@RequestMapping(value="/trouverEtudiantByEmail/{val}",method=RequestMethod.GET)
			public List<Etudiant> findByEmail(@PathVariable String val) {
				return etudiantController.findByEmail(val);
		}
			
		//modifier etudiant
			@RequestMapping(value="/updateEtudiant/{id}",method=RequestMethod.PUT)
			public Etudiant modifierProjet(@PathVariable(name="id") Long id,@RequestBody Etudiant e) {
				e.setId(id);
				return etudiantRepository.save(e);
			}
			
			

}
