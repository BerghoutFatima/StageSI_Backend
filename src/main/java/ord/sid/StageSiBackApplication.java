package ord.sid;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ord.sid.dao.EtudiantRepository;
import ord.sid.dao.ProjetRepository;
import ord.sid.entities.Etudiant;
import ord.sid.entities.Projet;
import ord.sid.service.StorageService;
 

@SpringBootApplication
public class StageSiBackApplication implements CommandLineRunner  {
	@Resource
	StorageService storageService;
	//pour l'ijection des dependances ==> @Autowired
	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	

	
	public static void main(String[] args) {
		SpringApplication.run(StageSiBackApplication.class, args);
	}
	
	 @Override
	  public void run(String... arg) throws Exception {
	    //storageService.deleteAll();
	    //storageService.init();
	  }

	/*@Override
	public void run(String... args) throws Exception {
		projetRepository.findAll().forEach(p->{
			System.out.println(p.getTitre());
		});
		etudiantRepository.findAll().forEach(e->{
			System.out.println(e.getUsername());
		});
		
	}*/
}
		
		
		//List<Etudiant> listeDesMembres = new ArrayList<Etudiant>();
				
		
		
		//this.projetRepository.save(projet);*/
		
		
		/*
	
		    
		  
		
	}
	@Override
	  public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	    projetRepository.findAll().forEach(p->{
			System.out.println(p.getTitre());
		});
		etudiantRepository.findAll().forEach(e->{
			System.out.println(e.getUsername());
		});
	  }*/
	 




