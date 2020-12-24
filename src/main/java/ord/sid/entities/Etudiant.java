package ord.sid.entities;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class Etudiant implements Serializable{
	@Id @GeneratedValue
	private Long id;
	private String username;
	private String laclasse;
	private String email;
	private String password;

	//@ManyToOne
   // @JoinColumn
	//private Projet projet;
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String username, String laclasse, String email, String password) {
		super();
		this.username = username;
		this.laclasse = laclasse;
		this.email = email;
		this.password = password;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLaclasse() {
		return laclasse;
	}
	public void setLaclasse(String laclasse) {
		this.laclasse = laclasse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

	