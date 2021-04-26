package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Departement implements Serializable {
	
	private static final Logger l = LogManager.getLogger(Departement.class);
	
    
	private static final long serialVersionUID = -357738161698377833L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	private String name;
	
	//@JsonManagedReference 
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Employe> employes;
	
	@OneToMany(mappedBy="departement")
	private List<Mission> missions;
	
	@ManyToOne
	private Entreprise entreprise;

	
	public Departement(int id, String name, List<Employe> employes, List<Mission> missions, Entreprise entreprise) {
		super();
		this.id = id;
		this.name = name;
		this.employes = employes;
		this.missions = missions;
		this.entreprise = entreprise;
		l.info("Constructeur Departement : ID="+id+" name: "+name+ "Entreprise: "+entreprise.getId());
	}
	public Departement(int id, String name,Entreprise entreprise) {
		super();
		this.id = id;
		this.name = name;
		this.entreprise = entreprise;
		l.info("Constructeur Departement : ID="+id+" name: "+name+ "Entreprise: "+entreprise.getId());
	}

	public Departement() {
		super();
		l.info("******  Appel au constructeur non paramétrer ****** ");
	}
	
	public Departement(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		l.info("Ajout ID : "+id+ "pour le département Name"+this.getName());
	}

	public String getName() {
		return name;
		
	}

	public void setName(String name) {
		this.name = name;
		l.info("Ajout ID : "+id+ "pour le département ID "+this.getId());
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	

}
