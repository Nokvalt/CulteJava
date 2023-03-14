package c.culte.response;

public class TapoteurResponse {
	protected Integer id;
	protected String nom;
	protected String prenom;
	protected String login;
	protected double sommeDon;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public double getSommeDon() {
		return sommeDon;
	}
	public void setSommeDon(double sommeDon) {
		this.sommeDon = sommeDon;
	}
	
	
}
