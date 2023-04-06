package c.culte.response;

import c.culte.model.Statut;

public class DemandeResponse {
	
	private Integer id;
	private Integer indenteurid;
	private String indenteurnom;
	private String indenteurprenom;
	private double montant;
	private String descriptif;
	private String statut;


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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Integer getIndenteurid() {
		return indenteurid;
	}

	public void setIndenteurid(Integer indenteurid) {
		this.indenteurid = indenteurid;
	}
	
	
	

	public String getIndenteurnom() {
		return indenteurnom;
	}

	public void setIndenteurnom(String indenteurnom) {
		this.indenteurnom = indenteurnom;
	}

	public String getIndenteurprenom() {
		return indenteurprenom;
	}

	public void setIndenteurprenom(String indenteurprenom) {
		this.indenteurprenom = indenteurprenom;
	}

	@Override
	public String toString() {
		return "DemandeResponse [id=" + id + ", indenteurid=" + indenteurid + ", montant=" + montant + ", descriptif="
				+ descriptif + ", statut=" + statut + "]";
	}
	
	
}
