package c.culte.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EvenementResponse {

	private int id;
	private String nom;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateEvent;
	private String lieu;
	private String nomActivite;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	@Override
	public String toString() {
		return "EvenementResponse [id=" + id + ", nom=" + nom + ", dateEvent=" + dateEvent + ", lieu=" + lieu
				+ ", nomActivite=" + nomActivite + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
