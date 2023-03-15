package c.culte.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DonRequest {
	
	private Integer tapoteurId;
	private double montant;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateDon;
	
	
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
	
	
	
	

}
