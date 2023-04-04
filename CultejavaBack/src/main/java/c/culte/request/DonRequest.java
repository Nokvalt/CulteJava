package c.culte.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DonRequest {
	
	private Integer tapoteurId;
	private String tapoteurNom;
	private double montant;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateDon;
	private String numCarte;
	private String moisExp;
	private String anneeExp;
	private String cvv;
	
	
	public Integer getTapoteurId() {
		return tapoteurId;
	}
	public void setTapoteurId(Integer tapoteur) {
		this.tapoteurId = tapoteur;
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
	public String getNumCarte() {
		return numCarte;
	}
	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}
	public String getMoisExp() {
		return moisExp;
	}
	public void setMoisExp(String moisExp) {
		this.moisExp = moisExp;
	}
	public String getAnneeExp() {
		return anneeExp;
	}
	public void setAnneeExp(String anneeExp) {
		this.anneeExp = anneeExp;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getTapoteurNom() {
		return tapoteurNom;
	}
	public void setTapoteurNom(String tapoteurNom) {
		this.tapoteurNom = tapoteurNom;
	}
	
	
	
	

}
