package c.culte.response;

import java.time.LocalDate;

import c.culte.model.Tapoteur;

public class DonResponse {
	
	private Integer id;
	private Tapoteur tapoteur;
	private double montant;
	private LocalDate dateDon;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Tapoteur getTapoteur() {
		return tapoteur;
	}
	public void setTapoteur(Tapoteur tapoteur) {
		this.tapoteur = tapoteur;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public LocalDate getDateDon() {
		return dateDon;
	}
	public void setDateDon(LocalDate dateDon) {
		this.dateDon = dateDon;
	}
	
	

}
