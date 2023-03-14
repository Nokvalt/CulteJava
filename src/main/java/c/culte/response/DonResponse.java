package c.culte.response;

import java.time.LocalDate;

public class DonResponse {
	
	private Integer id;
	private Integer tapoteurId;
	private double montant;
	private LocalDate dateDon;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTapoteurId() {
		return tapoteurId;
	}
	public void setTapoteurId(Integer tapoteurId) {
		this.tapoteurId = tapoteurId;
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
