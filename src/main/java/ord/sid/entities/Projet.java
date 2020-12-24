package ord.sid.entities;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;

@Entity
public class Projet implements Serializable {
	@Id @GeneratedValue
	private Long id;
	private String titre;
	private String descriptif;
	private String[] taches;
	private int status;
	private String laclasse;
	private Float note;
	private String[] date_depot_etudiant;
	@Temporal(TemporalType.DATE)
	private Date date_depot_responsable;
	//private Date date_depot_etudiant;
	private Date delai_realisation;
	private String[] livrables;
	private String[] commentaires;
	//@OneToMany (cascade = CascadeType.ALL)
	//@JoinColumn( name = "idProjet" , referencedColumnName = "id")
	//@OneToMany(mappedBy="projet")
    public String[] listeDesMembres;
	//public List<Etudiant> listeDesMembres = new ArrayList<>();
	
	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Projet(String titre, String descriptif, String[] taches, int status, String laclasse, Float note,
			Date date_depot_responsable, String[] date_depot_etudiant, Date delai_realisation, String[] livrables,
			String[] commentaires, String[] listeDesMembres) {
		super();
		this.titre = titre;
		this.descriptif = descriptif;
		this.taches = taches;
		this.status = status;
		this.laclasse = laclasse;
		this.note = note;
		this.date_depot_responsable = date_depot_responsable;
		this.date_depot_etudiant = date_depot_etudiant;
		this.delai_realisation = delai_realisation;
		this.livrables = livrables;
		this.commentaires = commentaires;
		this.listeDesMembres = listeDesMembres;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String[] getTaches() {
		return taches;
	}

	public void setTaches(String[] taches) {
		this.taches = taches;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getLaclasse() {
		return laclasse;
	}

	public void setLaclasse(String laclasse) {
		this.laclasse = laclasse;
	}

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}
	public Date getDate_depot_responsable() {
		return date_depot_responsable;
	}

	public void setDate_depot_responsable(Date date_depot_responsable) {
		this.date_depot_responsable = date_depot_responsable;
	}

	public String[] getDate_depot_etudiant() {
		return date_depot_etudiant;
	}

	public void setDate_depot_etudiant(String[] date_depot_etudiant) {
		this.date_depot_etudiant = date_depot_etudiant;
	}

	public Date getDelai_realisation() {
		return delai_realisation;
	}

	public void setDelai_realisation(Date delai_realisation) {
		this.delai_realisation = delai_realisation;
	}

	public String[] getLivrables() {
		return livrables;
	}

	public void setLivrables(String[] livrables) {
		this.livrables = livrables;
	}

	public String[] getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String[] commentaires) {
		this.commentaires = commentaires;
	}

	public String[] getListeDesMembres() {
		return listeDesMembres;
	}

	public void setListeDesMembres(String[] listeDesMembres) {
		this.listeDesMembres = listeDesMembres;
	}

	
}
