package c.culte.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import c.culte.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Bannis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	protected Integer id;
	
	@JsonView(Views.Bannis.class)
	@Column(length=50, nullable=false)
	private String nom;
	@JsonView(Views.Bannis.class)
	@Column(length=50, nullable=false)
	private String prenom;
	@JsonView(Views.Bannis.class)
	@Column(nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateBannissement;
	@JsonView(Views.Bannis.class)
	@Column(length=250, nullable=false)
	private String motif;
	@JsonView(Views.Bannis.class)
	@Column(length=150, nullable=false)
	private String infoBanquaires;
	
	@OneToOne
	@JoinColumn(nullable=false)
	private Tapoteur tapoteur;
	
	public Bannis() {}
	
	public Bannis(String nom, String prenom, LocalDate dateBannissement, String motif, String infoBanquaires) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateBannissement = dateBannissement;
		this.motif = motif;
		this.infoBanquaires = infoBanquaires;
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

	public Tapoteur getTapoteur() {
		return tapoteur;
	}

	public void setTapoteur(Tapoteur tapoteur) {
		this.tapoteur = tapoteur;
	}
	
	
	
	
	
	
}
