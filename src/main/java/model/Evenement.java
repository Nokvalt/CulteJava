package model;

public class Evenement {
	
	protected String nom;
	protected String dateEvent;
	protected String lieu;
	protected Activite activiteEvent;
	
	public Evenement(String nom, String dateEvent, String lieu, Activite activiteEvent) {
		super();
		this.nom = nom;
		this.dateEvent = dateEvent;
		this.lieu = lieu;
		this.activiteEvent = activiteEvent;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Activite getActiviteEvent() {
		return activiteEvent;
	}

	public void setActiviteEvent(Activite activiteEvent) {
		this.activiteEvent = activiteEvent;
	}
	
	

}
