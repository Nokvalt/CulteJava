package c.culte.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public abstract class TapoteurResponse {
	protected Integer id;
	protected String nom;
	protected String prenom;
	protected String login;
	protected String password;
	@JsonFormat(pattern="yyyy-MM-dd")
	protected LocalDate dateAdhesion;
	protected double sommeDon;
	protected String numero;
	protected String voie;
	protected String ville;
	protected String cp;
	protected String pays;
	
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
	
	
	public LocalDate getDateAdhesion() {
		return dateAdhesion;
	}
	public void setDateAdhesion(LocalDate dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}
	public abstract String getRang();
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
}
