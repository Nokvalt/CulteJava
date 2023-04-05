package c.culte.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
import jakarta.persistence.OneToOne;

@Entity
public class Demande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Demande.class)
	private Integer id;
	@Column(nullable=false)
	@JsonView(Views.Demande.class)
	private double montant;
	@Column(nullable=false)
	@JsonView(Views.Demande.class)
	private String descriptif;
	@Column(nullable=false, columnDefinition = "ENUM('enAttente', 'refusé')")
	@Enumerated(EnumType.STRING)
	@JsonView(Views.Demande.class)
	private Statut statut;
	@OneToOne
	@JoinColumn(name="indenteur", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Indenteur indenteur;
	
	public Demande() {}
	
	public Demande(double montant, String descriptif) {
		this.montant = montant;
		this.descriptif = descriptif;
		this.statut = Statut.enAttente;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Indenteur getIndenteur() {
		return indenteur;
	}

	public void setIndenteur(Indenteur indenteur) {
		this.indenteur = indenteur;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	
	
	
}
