package c.culte.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import c.culte.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Evenement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Evenement.class)
	private Integer id;
	@Column(length = 150, nullable = false)
	private String nom;
	@Column(nullable = false)
	private LocalDate dateEvent;
	@Column(length = 50, nullable = false)
	private String lieu;

	@Column(name = "activite", columnDefinition = "ENUM('feteCreation', 'naissanceProphete', 'fetePopups', 'rassemblement', 'pelerinnage', 'promotion')")
	@Enumerated(EnumType.STRING)
	private Activite activiteEvent;
	
	@ManyToMany(mappedBy="inscriptions")
	private List<Fidele> inscrits;
	
	@ManyToOne
	@JoinColumn(name = "culte", nullable = false)
	private Culte culte;

	public Evenement() {
	}

	public Evenement(String nom, LocalDate dateEvent, String lieu, Activite activiteEvent) {
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

	public LocalDate getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(LocalDate dateEvent) {
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

	public Culte getCulte() {
		return culte;
	}

	public void setCulte(Culte culte) {
		this.culte = culte;
	}

}
