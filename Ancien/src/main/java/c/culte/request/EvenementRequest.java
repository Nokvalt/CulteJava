package c.culte.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EvenementRequest {

	private String nom;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateEvent;
	private String lieu;
	private String nomActivite;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public LocalDate getDateEvent() {
		return dateEvent;
	}
	public void setDateEvent(LocalDate dateEvent) {
		this.dateEvent = dateEvent;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getNomActivite() {
		return nomActivite;
	}
	public void setNomActivite(String nomActivite) {
		this.nomActivite = nomActivite;
	}
	
	
}
