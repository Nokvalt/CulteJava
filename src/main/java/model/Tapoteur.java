package model;

public class Tapoteur {
	
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String dateAdhesion;
	protected String login;
	protected String password;

	
	public Tapoteur(String nom,String prenom,String adresse,String dateAdhesion,String login,String password)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateAdhesion = dateAdhesion;
		this.login = login;
		this.password = password;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getDateAdhesion() {
		return dateAdhesion;
	}


	public void setDateAdhesion(String dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
