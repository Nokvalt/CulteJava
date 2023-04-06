package c.culte.response;

import c.culte.model.Statut;

public class DemandeResponse {
	
	private Integer id;
	private Integer indenteurid;
	private double montant;
	private String descriptif;
	private Statut statut;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getIndenteurid() {
		return indenteurid;
	}

	public void setIndenteurid(Integer indenteurid) {
		this.indenteurid = indenteurid;
	}
}
