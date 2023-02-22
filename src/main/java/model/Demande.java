package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Demande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private double montant;
	private String descriptif;
	private Statut statut;
	@OneToOne(mappedBy="statutDemande")
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
