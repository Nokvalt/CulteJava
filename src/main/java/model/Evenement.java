package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Evenement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String dateEvent;
	private String lieu;
	
	@Column(name="activite",columnDefinition = "ENUM('feteCreation', 'naissanceProphete', 'fetePopups', 'rassemblement', 'pelerinnage', 'promotion')")
	@Enumerated(EnumType.STRING)
	private Activite activiteEvent;
	
	@ManyToOne
	private Culte culte;
	
	public Evenement() {}
	
	public Evenement(String nom, String dateEvent, String lieu, Activite activiteEvent) {
		super();
		this.nom = nom;
		this.dateEvent = dateEvent;
		this.lieu = lieu;
		this.activiteEvent = activiteEvent;
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

	public String getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Activite getActiviteEvent() {
		return activiteEvent;
	}

	public void setActiviteEvent(Activite activiteEvent) {
		this.activiteEvent = activiteEvent;
	}
	
	

}
