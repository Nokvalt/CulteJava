package model;

public class Demande {
	
	private double montant;
	private String descriptif;
	private Statut statut;
	
	public Demande(double montant, String descriptif, Statut statut) {
		super();
		this.montant = montant;
		this.descriptif = descriptif;
		this.statut = statut;
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
