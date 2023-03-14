package c.culte.request;

import java.time.LocalDate;

public class EvenementRequest {

	private String nom;
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