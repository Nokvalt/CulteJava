package c.culte.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TapoteurResponse {
	private Integer id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateAdhesion;
	private String numero;
	private String voie;
	private String ville;
	private String cp;
	private String pays;
	private String rang;
	protected String punition;
	protected String imageProfil;
	
	//fidele
	protected double sommeDon;
	
	//indenteur
	private Integer demandeId;
	private double demandeMontant;
	private String demandeStatut;
	
	//compileur
	
	//grandev
	private double allDons;
	private double argentVole;
	
	public double getAllDons() {
		return allDons;
	}
	public void setAllDons(double allDons) {
		this.allDons = allDons;
	}
	public double getArgentVole() {
		return argentVole;
	}
	public void setArgentVole(double argentVole) {
		this.argentVole = argentVole;
	}
	public Integer getDemandeId() {
		return demandeId;
	}
	public void setDemandeId(Integer demandeId) {
		this.demandeId = demandeId;
	}
	public double getDemandeMontant() {
		return demandeMontant;
	}
	public void setDemandeMontant(double demandeMontant) {
		this.demandeMontant = demandeMontant;
	}
	public String getDemandeStatut() {
		return demandeStatut;
	}
	public void setDemandeStatut(String demandeStatut) {
		this.demandeStatut = demandeStatut;
	}
	
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
	
	public String getRang() {
		return rang;
	}
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
	public String getPunition() {
		return punition;
	}
	public void setPunition(String punition) {
		this.punition = punition;
	}
	public void setRang(String rang) {
		this.rang = rang;
	}
	public String getImageProfil() {
		return imageProfil;
	}
	public void setImageProfil(String imageProfil) {
		this.imageProfil = imageProfil;
	}
	
	
	
	
	
	
	
	
}
