package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Demande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private double montant;
	@Column(nullable=false)
	private String descriptif;
	@Column(nullable=false)
	private Statut statut;
	@OneToOne
	@JoinColumn(name="indenteur", nullable=false)
	private Indenteur indenteur;
	
	public Demande() {}
	
	public Demande(double montant, String descriptif, Statut statut) {
		this.montant = montant;
		this.descriptif = descriptif;
		this.statut = statut;
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
