package c.culte.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonView;

import c.culte.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bannis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Bannis.class)
	protected Integer id;
	
	@Column(length=50, nullable=false)
	private String nom;
	@Column(length=50, nullable=false)
	private String prenom;
	@Column(nullable=false)
	private LocalDate dateBannissement;
	@Column(length=250, nullable=false)
	private String motif;
	@Column(length=150, nullable=false)
	private String infoBanquaires;
	
	public Bannis() {}
	
	public Bannis(String nom, String prenom, LocalDate dateBannissement, String motif, String infoBanquaires) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateBannissement = dateBannissement;
		this.motif = motif;
		this.infoBanquaires = infoBanquaires;
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
	public LocalDate getDateBannissement() {
		return dateBannissement;
	}
	public void setDateBannissement(LocalDate dateBannissement) {
		this.dateBannissement = dateBannissement;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getInfoBanquaires() {
		return infoBanquaires;
	}

	public void setInfoBanquaires(String infoBanquaires) {
		this.infoBanquaires = infoBanquaires;
	}
	
	
	
	
}
