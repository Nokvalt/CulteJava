package c.culte.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="rang_tapoteur", columnDefinition = "ENUM('fidele','indenteur','compileur','grandDev')")
public abstract class Tapoteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(length=50, nullable=false)
	protected String nom;
	@Column(length=50, nullable=false)
	protected String prenom;
	@Embedded
	protected Adresse adresse;
	@Column(nullable=false)
	protected LocalDate dateAdhesion;
	@Column(length=25, nullable=false)
	protected String login;
	@Column(length=25, nullable=false)
	protected String password;
	
	@ManyToOne
	@JoinColumn(name="culte", nullable=false)
	protected Culte culte;
	

	
	public Tapoteur() {}


	public Tapoteur(String nom,String prenom,Adresse adresse,LocalDate dateAdhesion,String login,String password)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateAdhesion = dateAdhesion;
		this.login = login;
		this.password = password;
	}
	
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public LocalDate getDateAdhesion() {
		return dateAdhesion;
	}


	public void setDateAdhesion(LocalDate dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Culte getCulte() {
		return culte;
	}


	public void setCulte(Culte culte) {
		this.culte = culte;
	}


	@Override
	public String toString() {
		return "Tapoteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", dateAdhesion="
				+ dateAdhesion + ", login=" + login + ", password=" + password + ", culte=" + culte + "]";
	}
	
	
	
}
