package c.culte.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DonResponse {
	
	private Integer id;
	private double montant;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateDon;
	private Integer tapoteurId;
	private String tapoteurNom;
	private String tapoteurPrenom;
	
	
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
	public LocalDate getDateDon() {
		return dateDon;
	}
	public void setDateDon(LocalDate dateDon) {
		this.dateDon = dateDon;
	}
	public Integer getTapoteurId() {
		return tapoteurId;
	}
	public void setTapoteurId(Integer tapoteurId) {
		this.tapoteurId = tapoteurId;
	}
	public String getTapoteurNom() {
		return tapoteurNom;
	}
	public void setTapoteurNom(String tapoteurNom) {
		this.tapoteurNom = tapoteurNom;
	}
	public String getTapoteurPrenom() {
		return tapoteurPrenom;
	}
	public void setTapoteurPrenom(String tapoteurPrenom) {
		this.tapoteurPrenom = tapoteurPrenom;
	}
	
	
	

}
